package com.dyu.design.concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author dyu
 * @date 2018/09/08
 */
public class Latch {

    static CountDownLatch latch = new CountDownLatch(10);

    @Test
    public void together() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //try {
                    //    Thread.sleep((long) (Math.random() * 1000));
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                    System.out.println(Thread.currentThread().getName());
                    //latch.countDown();
                }
            }, "thread" + i);
            thread.start();

        }
        latch.await();
        System.out.println("over...");
    }
}
