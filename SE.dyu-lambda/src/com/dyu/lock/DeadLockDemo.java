package com.dyu.lock;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class DeadLockDemo {

    private static String one = "a";
    private static String two = "b";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (one) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (two) {
                        System.out.println("1");
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (two) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (one) {
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
