package com.zk;
import org.apache.zookeeper.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Created by adimn on 2018/1/5.
 */

/**
 * Zookeepr实现分布式锁
 */
public class ZKLock {


    private String zkQurom = "localhost:2181";

    private String lockNameSpace = "/mylock";

    private String nodeString = lockNameSpace + "/test1";

    private Lock mainLock;

    private ZooKeeper zk;

    public ZKLock(){
        try {
            zk = new ZooKeeper(zkQurom, 6000, new Watcher() {
//                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("Receive event "+watchedEvent);
                    if(Event.KeeperState.SyncConnected == watchedEvent.getState())
                        System.out.println("connection is established...");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void ensureRootPath() throws InterruptedException {
        try {
            if (zk.exists(lockNameSpace,true)==null){
                zk.create(lockNameSpace,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    private void watchNode(final String nodeString, final Thread thread) throws InterruptedException {
        try {
            zk.exists(nodeString, new Watcher() {
//                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println( "==" + watchedEvent.toString());
                    if(watchedEvent.getType() == Event.EventType.NodeDeleted){
                        System.out.println("Threre is a Thread released Lock==============");
                        thread.interrupt();
                    }
                    try {
                        zk.exists(nodeString,new Watcher() {
//                            @Override
                            public void process(WatchedEvent watchedEvent) {
                                System.out.println( "==" + watchedEvent.toString());
                                if(watchedEvent.getType() == Event.EventType.NodeDeleted){
                                    System.out.println("Threre is a Thread released Lock==============");
                                    thread.interrupt();
                                }
                                try {
                                    zk.exists(nodeString,true);
                                } catch (KeeperException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        });
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取锁
     * @return
     * @throws InterruptedException
     */
    public boolean lock() throws InterruptedException {
        String path = null;
        ensureRootPath();
        watchNode(nodeString,Thread.currentThread());
        while (true) {
            try {
                path = zk.create(nodeString, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } catch (KeeperException e) {
                System.out.println(Thread.currentThread().getName() + "  getting Lock but can not get");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException ex){
                    System.out.println("thread is notify");
                }
            }
            if (!"".equals(path.trim())) {
                System.out.println(Thread.currentThread().getName() + "  get Lock...");
                return true;
            }
        }
    }

    /**
     * 释放锁
     */
    public void unlock(){
        try {
            zk.delete(nodeString,-1);
            System.out.println("Thread.currentThread().getName() +  release Lock...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0;i<4;i++){
            service.execute(()-> {
                ZKLock test = new ZKLock();
                try {
                    test.lock();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.unlock();
            });
        }
        service.shutdown();
    }
}
