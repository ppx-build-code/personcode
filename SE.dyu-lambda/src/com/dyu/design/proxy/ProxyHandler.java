package com.dyu.design.proxy;

import com.dyu.lock.DeadLockDemo;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dyu
 * @date 2018/09/09
 */
public class ProxyHandler implements InvocationHandler {
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy invoke pre...");
        method.invoke(target, args);
        System.out.println("proxy invoke post...");
        return null;
    }

    public static void main(String[] args) throws IOException {
        ProxyHandler proxyHandler = new ProxyHandler(new TargetImpl());

        Target proxy = (Target) Proxy.newProxyInstance(DeadLockDemo.class.getClassLoader(), new Class[]{Target.class}, proxyHandler);
        proxy.test();

        byte [] bs = ProxyGenerator.generateProxyClass("@Proxy1", new Class[]{Target.class}, 1);
        OutputStream os = new FileOutputStream("/Users/yudi/personfile/workspaces/personcode/SE.dyu-lambda/test/production/dyu-lambda/com/dyu/design/proxy/$Proxy1.class");
        os.write(bs);
        os.flush();
        os.close();



    }

}
