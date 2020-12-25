package com.dyu.threadlocal;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.ReflectionUtil;
import jdk.nashorn.internal.parser.JSONParser;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dyu 2020/12/25 09:50
 */
public class ThreadLocalDemo {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException, NoSuchFieldException {
        final ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("main thread.");
        final Runnable task = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " >>>>> helloworld");
                System.out.println(Thread.currentThread().getName() + " thread local get " + threadLocal.get());
            }
        };
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                threadLocal.set("t1 thread.");
                task.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                threadLocal.set("t2 thread.");
                task.run();
            }
        }, "t2");


        t1.start();
        t2.start();
        //t1.join();
        t2.join();
        System.gc();

        Method getMap = ThreadLocal.class.getDeclaredMethod("getMap", Thread.class);
        getMap.setAccessible(true);
        Object invoke = getMap.invoke(threadLocal, t1);
        String s = JSON.toJSONString(invoke);
        System.out.println(s);
        System.out.println(invoke);

        Field field = Thread.class.getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object o = field.get(t1);
        System.out.println(o);

        Field table = o.getClass().getDeclaredField("table");
        table.setAccessible(true);
        Object [] tableVal = (Object[]) table.get(o);
        System.out.println(tableVal.length);
        System.out.println(JSON.toJSONString(tableVal));
    }
}
