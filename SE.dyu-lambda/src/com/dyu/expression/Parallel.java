package com.dyu.expression;

/**
 * @author dyu
 * @date 2018/07/15
 */
public class Parallel {

    public static final int count = 100001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });

        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("currency :" + time + "ms,b=" + b);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis();
        System.out.println("serial:" + time + "ms, b=" + b);
    }

}
