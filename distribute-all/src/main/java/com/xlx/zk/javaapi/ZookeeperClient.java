package com.xlx.zk.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperClient {
    private static final String CONN = "localhost:2181";

    public static final int SESSIONTIMEOUT = 5000;

    public static ZooKeeper getZookeeperClient() throws IOException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONN, SESSIONTIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState()== Event.KeeperState.SyncConnected){
                    System.out.println("--连接成功...");
                    latch.countDown();
                }
            }
        });
        System.out.println("--等待连接....");
        latch.await();
        System.out.println("--返回连接实例....");
        return zooKeeper;
    }
}
