package com.xlx.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.framework.api.transaction.TypeAndPath;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Op;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CuratorSession {

    private static final String CONN = "localhost:2181";

    public static void main(String[] args) throws Exception {
        // 创建
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONN, 2000, 5000, new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        System.out.println(curatorFramework.getState());
        //另一种方式
        //curatorFramework = CuratorFrameworkFactory.builder().build();

        // 新增节点
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/curator/chd/dd","dfadfe".getBytes());

        //读取
        byte[] data = curatorFramework.getData().forPath("/curator/chd/dd");
        java.lang.String string = new java.lang.String(data);
        System.out.println(string);

        // 修改
        Stat stat = curatorFramework.setData().forPath("/curator/chd/dd","fdaefv".getBytes());
        System.out.println(stat);

        curatorFramework.setData().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println(event);
            }
        }).forPath("/curator/chd/dd","fafdae".getBytes());

        //删除
        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator/chd");

        //异步
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        curatorFramework.setData().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println(event.getData());
            }
        },executorService).forPath("/curator/chd/dd","fafdae".getBytes());

        //事务
        // this example shows how to use ZooKeeper's transactions
        CuratorOp createOp = curatorFramework.transactionOp().create().forPath("/a/path", "some data".getBytes());
        CuratorOp setDataOp = curatorFramework.transactionOp().setData().forPath("/another/path", "other data".getBytes());
        CuratorOp deleteOp = curatorFramework.transactionOp().delete().forPath("/yet/another/path");

        Collection<CuratorTransactionResult> results = curatorFramework.transaction().forOperations(createOp, setDataOp, deleteOp);

        for ( CuratorTransactionResult result : results )
        {
            System.out.println(result.getForPath() + " - " + result.getType());
        }

        //
        Thread.sleep(2000);
    }
}
