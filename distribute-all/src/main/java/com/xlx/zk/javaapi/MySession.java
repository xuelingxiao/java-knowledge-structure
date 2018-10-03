package com.xlx.zk.javaapi;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;


public class MySession {

    private static final String CONN = "localhost:2181";
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(CONN, 1000, new MyWatcher());

        // 创建
        zooKeeper.create("/xlx", "this is a string".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 查询,注册watcher
        byte[] rst = zooKeeper.getData("/xlx", true, stat);
        System.out.println(new String(rst));

        //删除(只能删除永久节点)
        zooKeeper.delete("/xlx", -1);

        // 创建
        zooKeeper.create("/xlx", "this is a string".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 查询
        byte[] rs = zooKeeper.getData("/xlx", true, stat);
        System.out.println(new String(rs));

        // 注册watcher
        zooKeeper.exists("/xlx/yy", true);

        // 创建
        zooKeeper.create("/xlx/yy", "this is a sub child string".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


        // 修改
        zooKeeper.setData("/xlx", "this is a modified string".getBytes(), -1);
        byte[] rss = zooKeeper.getData("/xlx", true, stat);
        System.out.println(new String(rss));

        // 获取子节点
        List<String> children = zooKeeper.getChildren("/xlx", true);
        System.out.println(children);

        //删除(只能删除永久节点)
        zooKeeper.delete("/xlx/yy", -1);
        //删除(只能删除永久节点)
        zooKeeper.delete("/xlx", -1);

        // watcher 异步的, 这里停留段时间才可以查看到watcher打印的信息
        Thread.sleep(2000);
    }
}
