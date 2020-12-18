package com.dyu.pool;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * @author deepin_virgil
 */
public class ThreadPoolPerformance {
    public static void main(String[] args) {

        //ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(2));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.MINUTES, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("come in," + Thread.currentThread().getName() + "," + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("come out," + Thread.currentThread().getName() + "," + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()));

                }
            });
        }
        executor.shutdown();
    }
}