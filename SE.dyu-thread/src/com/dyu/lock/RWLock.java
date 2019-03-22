package com.dyu.lock;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dyu
 * @date 2018/12/15
 */
public class RWLock {

    static Map<String, Object> cache = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock w = lock.writeLock();
    static Lock r = lock.readLock();

    public static Object get(String key) {
        r.lock();
        Object value;
        try {
            value = cache.get(key);
            return value;
        } finally {
            r.unlock();
        }
    }

    public static void set(String key, Object value) {
        w.lock();

        try {
            cache.put(key, value);
        } finally {
            //w.unlock();
        }
    }

    public static void clear() {
        w.lock();
        try {
            cache.clear();
        } finally {
          w.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String[] keys = new String[]{"one", "two", "three"};

        Thread rt = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " ---> 读取数据中");
                    Object result = RWLock.get(keys[new Random().nextInt(3)]);
                    System.out.println(Thread.currentThread().getName() + " ---> 读取内容为：" + result);

                }
            }
        }, "rt");

        Thread wt1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                while (true) {
                    a += 1;
                    System.out.println(Thread.currentThread().getName() + " ---> 写入数据中");
                    RWLock.set(keys[new Random().nextInt(3)], UUID.randomUUID());
                    if (a == 3) {
                        w.unlock();
                    }
                    if (a == 6) {
                        w.unlock();
                        return;
                    }

                }
            }
        }, "wt1");

        Thread wt2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ---> 写入数据中");
                RWLock.set(keys[new Random().nextInt(3)], UUID.randomUUID());
            }
        }, "wt2");

        //rt.start();
        wt1.start();
        wt1.interrupt();
        //wt2.start();
        //wt1.start();
        //rt.start();
    }
}
