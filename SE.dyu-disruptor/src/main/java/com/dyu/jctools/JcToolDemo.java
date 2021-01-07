package com.dyu.jctools;

import org.jctools.queues.MpscGrowableArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu 2021/1/7 10:27
 */
public class JcToolDemo {


    public static void main(String[] args) throws InterruptedException {
        final MpscGrowableArrayQueue queue = new MpscGrowableArrayQueue(1000);

        List<Thread> ts = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        queue.add(Thread.currentThread().getName() + " >>> " + i);
                    }
                }
            }, "thread " + i);
            ts.add(t);
        }

        for (int i = 0; i < 10; i++) {
            ts.get(i).start();
        }

        Thread.sleep(5);

        while (true) {
            System.out.println(queue.peek());
        }

    }
}
