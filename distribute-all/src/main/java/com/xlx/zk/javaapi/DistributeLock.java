package com.xlx.zk.javaapi;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DistributeLock {

    private static final String ROOT_LOCKS="/LOCK";
    private ZooKeeper zooKeeper;
    private int sessionTimeout;
    private String lockID;
    private final static byte[] date={1,2};
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public DistributeLock() throws IOException, InterruptedException {
        this.zooKeeper = ZookeeperClient.getZookeeperClient();
        this.sessionTimeout = ZookeeperClient.SESSIONTIMEOUT;
    }

    public boolean lock(){
        try{
            lockID = zooKeeper.create(ROOT_LOCKS+"/",date, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName()+"->成功创建了lock节点["+lockID+"], 开始去竞争锁");
            List<String> childrenNodes = zooKeeper.getChildren(ROOT_LOCKS,true);
            SortedSet<String> sortedSet = new TreeSet<>();
            for(String children:childrenNodes){
                sortedSet.add(ROOT_LOCKS+"/"+children);
            }
            String first = sortedSet.first();
            if (first.equals(lockID)){
                System.out.println(Thread.currentThread().getName()+"->成功获得锁，lock节点为:["+lockID+"]");
                return true;
            }

            SortedSet<String> lessThanLockId = ((TreeSet<String>) sortedSet).headSet(lockID);
            if (!lessThanLockId.isEmpty()){
                String prevLockID = lessThanLockId.last();
                zooKeeper.exists(prevLockID,new LockWatcher(countDownLatch));
                countDownLatch.await(sessionTimeout,TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName()+" 成功获取锁：["+lockID+"]");
            }
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    public boolean unlock(){
        System.out.println(Thread.currentThread().getName()+"->开始释放锁:["+lockID+"]");
        try {
            zooKeeper.delete(lockID,-1);
            System.out.println("节点["+lockID+"]成功被删除");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        final CountDownLatch latch=new CountDownLatch(10);
        Random random=new Random();
        for(int i=0;i<10;i++){
            new Thread(()->{
                DistributeLock lock=null;
                try {
                    lock=new DistributeLock();
                    latch.countDown();
                    latch.await();
                    lock.lock();
                    Thread.sleep(random.nextInt(500));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(lock!=null){
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
