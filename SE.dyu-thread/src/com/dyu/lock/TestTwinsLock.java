package com.dyu.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author dyu
 * @date 2018/12/02
 */
public class TestTwinsLock {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);

                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println();
        }


    }
}
