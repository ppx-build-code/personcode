package com.dyu.segment;

import java.util.concurrent.*;

/**
 * @author dyu 2019/12/27 14:03
 */
public class ContainerCargoSegment {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch count1 = new CountDownLatch(1);
        CountDownLatch count2 = new CountDownLatch(1);

        FutureTask f1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                count2.await();
                Thread.sleep(500L);

                System.out.println("first...");
                return null;
            }
        });

        FutureTask f2 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                count1.await();
                Thread.sleep(500L);
                System.out.println("second...");
                count2.countDown();
                return null;
            }
        });

        FutureTask f3 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {

                Thread.sleep(500L);
                System.out.println("third...");
                count1.countDown();
                return null;
            }
        });
        executorService.submit(f1);
        executorService.submit(f2);
        executorService.submit(f3);
        f1.get();
        f2.get();
        f3.get();


    }
}
