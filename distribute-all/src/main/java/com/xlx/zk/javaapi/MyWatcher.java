package com.xlx.zk.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 定义Watcher
 */
public class MyWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            System.out.println("---->>>>>"+event.getType());
            System.out.println("---->>>>>"+event.getPath());
        }
    }
}
