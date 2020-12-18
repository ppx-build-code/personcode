package com.dyu.design.proxy;


import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.TypePath;
import org.springframework.cglib.core.ClassGenerator;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.transform.TransformingClassGenerator;
import org.springframework.cglib.transform.impl.AddPropertyTransformer;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @author dyu
 * @date 2018/09/09
 */
public class CglibProxyHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cut in proxy...");
        return methodProxy.invokeSuper(o, objects);
    }

    public static void main(String[] args) throws IOException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Temp.class);
        enhancer.setCallback(new CglibProxyHandler());

        Temp target = (Temp) enhancer.create();
        target.test();


        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yudi/personfile/workspaces/personcode/SE.dyu-lambda/test/production/dyu-lambda/com/dyu/design/proxy/$Proxy2.class");

    }
}
