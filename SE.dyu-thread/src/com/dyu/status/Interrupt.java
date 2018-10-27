package com.dyu.status;

import java.util.concurrent.TimeUnit;

/**
 * @author dyu
 * @date 2018/10/27
 */
public class Interrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner());
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner());
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleep thread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busy thread interrupted is " + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                    System.out.println("hello world");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
            }
        }
    }


}
