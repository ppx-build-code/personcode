package com.dyu.lock;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dyu
 * @date 2018/12/15
 */
public class FairAndUnfairLock {
    private static Lock fair = new ReentrantLock2(true);
    private static Lock unfair = new ReentrantLock2(false);

    public void fair() {
        testLock(fair);
    }

    public void unfair() {
        testLock(unfair);
    }

    public void testLock(Lock lock) {

        Arrays.asList("1,2,3,4,5".split(",")).parallelStream().forEach(o -> new Job(lock).start());
    }


    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("first current thread ---> " + Thread.currentThread().getName());
            if (lock instanceof ReentrantLock2) {
                Collection<Thread> ts = ((ReentrantLock2) lock).getQueuedThreads();
                ts.stream().map(Thread::getName).forEach(System.out::println);
            }
            lock.unlock();

            lock.lock();

            System.out.println("second current thread ---> " + Thread.currentThread().getName());
            if (lock instanceof ReentrantLock2) {
                Collection<Thread> ts = ((ReentrantLock2) lock).getQueuedThreads();
                ts.stream().map(Thread::getName).forEach(System.out::println);
            }
            lock.unlock();
        }
    }



    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairAndUnfairLock lock = new FairAndUnfairLock();
        lock.fair();
        //
        //Thread.sleep(10000);

        System.out.println();
        //lock.unfair();
    }
}
