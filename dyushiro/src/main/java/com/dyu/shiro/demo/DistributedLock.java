package com.dyu.shiro.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.jboss.netty.util.internal.SystemPropertyUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yudi on 2018/4/3.
 */
public class DistributedLock implements Lock, Watcher {

    private ZooKeeper zk = null;
    // 根节点
    private String ROOT_LOCK = "/locks";
    // 竞争的资源
    private String lockName;
    // 等待的前一个锁
    private String WAIT_LOCK;
    // 当前锁
    private String CURRENT_LOCK;
    // 计数器
    private CountDownLatch countDownLatch;
    private int sessionTimeout = 30000;
    private List<Exception> exceptionList = new ArrayList<Exception>();


    public DistributedLock(String config, String lockName){
        this.lockName = lockName;
        try {
            zk = new ZooKeeper(config, sessionTimeout, this);
            Stat stat = zk.exists(ROOT_LOCK, false);
            if(stat == null){
                zk.create(ROOT_LOCK, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void lock() {

        if(exceptionList.size() > 0){
            throw new LockException(exceptionList.get(0));
        }
        if(this.tryLock()){
            System.out.println(Thread.currentThread().getName() + " " + lockName + "获取了锁");
            return;
        }else{
            try {
                waitForLock(WAIT_LOCK, sessionTimeout);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {

        String splitStr = "_lock_";
        if(lockName.contains(splitStr)){
            throw new LockException("锁名称有误！");
        }
        try {
            CURRENT_LOCK = zk.create(ROOT_LOCK + "/" + lockName + splitStr, new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            List<String> childNode = zk.getChildren(ROOT_LOCK, false);
            final List<String> lockObjects = new ArrayList<String>();

            childNode.forEach(item ->{
                if(lockName.equals(item.split(splitStr)[0])){
                    lockObjects.add(item);
                }
            });
            Collections.sort(lockObjects);
            System.out.println(Thread.currentThread().getName() + "的锁是：" + CURRENT_LOCK);

            if(CURRENT_LOCK.equals(ROOT_LOCK + "/" + childNode.get(0))){
                return true;
            }

            String prevNode = CURRENT_LOCK.substring(CURRENT_LOCK.lastIndexOf("/") + 1);
            System.out.println(Thread.currentThread().getName() + "的前一个节点为：" + prevNode);

            WAIT_LOCK = lockObjects.get(Collections.binarySearch(lockObjects, prevNode) - 1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean waitForLock(String prev, long waitTime) throws KeeperException, InterruptedException {
            Stat stat = zk.exists(ROOT_LOCK + "/" + prev, true);

            if(stat != null){
                System.out.println(Thread.currentThread().getName() + "等待锁" + ROOT_LOCK + "/" + prev);
                this.countDownLatch = new CountDownLatch(1);
                this.countDownLatch.await(waitTime, TimeUnit.MILLISECONDS);
                this.countDownLatch = null;
                System.out.println(Thread.currentThread().getName() + "等到了锁");
            }

            return true;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        if(this.tryLock()){
            return true;
        }
        try {
            return waitForLock(WAIT_LOCK, time);
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void unlock() {
        try {
            System.out.println("释放锁" + CURRENT_LOCK);
            zk.delete(CURRENT_LOCK,  -1);
            CURRENT_LOCK = null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }

    public ZooKeeper getZookeeper(){
        return this.zk;
    }

    public static void deleteSubNode(ZooKeeper zk, String nodeStr) throws IOException, KeeperException, InterruptedException {
        String nodePath = nodeStr;
        //打印当前节点路径
        System.out.println("Node Path >>>>>>>>> [" + nodePath + " ]");
        if (zk.getChildren(nodePath, false).size() == 0) {
            //删除节点
            System.out.println("Deleting Node Path >>>>>>>>> [" + nodePath + " ]");
             zk.delete(nodePath,-1);
        } else {
            //递归查找非空子节点
            List<String> list = zk.getChildren(nodeStr, true);
            for (String str : list) {
                deleteSubNode(zk, nodePath + "/" + str);
            }
        }
    }

    public Condition newCondition() {
        return null;
    }

    public void process(WatchedEvent watchedEvent) {

    }


    public class LockException extends RuntimeException{
        private static final long serialialVersionUID = 1L;

        public LockException(String e){
            super(e);
        }

        public LockException(Exception e){
            super(e);
        }
    }

    static int num = 500;

    public static void setValue(){
        num--;
    }


    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        DistributedLock distributedLocks = new DistributedLock("127.0.0.1:2181", "test");
        System.out.println(distributedLocks.getZookeeper().getChildren("/locks", false));
        deleteSubNode(distributedLocks.getZookeeper(), "/locks");
        for(int i = 0; i < 30; i ++){
            DistributedLock distributedLock = new DistributedLock("127.0.0.1:2181", "test");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    distributedLock.lock();
                    DistributedLock.setValue();
                    System.out.println(Thread.currentThread().getName() + "正在运行中...");
                    distributedLock.unlock();
                }
            }).start();
        }

    }
}
