package com.xlx.zk.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

public class LockWatcher implements Watcher {

    private CountDownLatch latch = null;

    public LockWatcher(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType()== Event.EventType.NodeDeleted){
            this.latch.countDown();
        }
    }
}
