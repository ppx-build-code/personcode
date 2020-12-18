package com.dyu.status;

import java.util.concurrent.TimeUnit;

/**
 * @author dyu
 * @date 2018/10/27
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runner(), "countThread");
        one.start();
        TimeUnit.SECONDS.sleep(1);
        one.interrupt();
        Runner two = new Runner();
        Thread thread = new Thread(two, "countThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i ++;
            }
            System.out.println("Count i =" + i);
        }

        public void cancel() {
            on = false;
        }
    }

}
