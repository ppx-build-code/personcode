package com.dyu.daemon;

/**
 * @author dyu 2020/7/1 21:50
 */
public class ServiceThread {


    public static void main(String[] args) throws InterruptedException {

        final long[] a = {2000L};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread subt = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("daemon start.");
                            try {
                                Thread.sleep(2000L);
                                a[0] += 1000;
                                System.out.println("daemon thread add timeout time");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    subt.setDaemon(true);
                    subt.start();
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("do work.");
            }
        });

        thread.start();
        Thread.sleep(5000L);
        System.out.println(a[0]);
    }
}
