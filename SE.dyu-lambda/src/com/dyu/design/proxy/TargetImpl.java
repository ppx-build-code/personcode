package com.dyu.design.proxy;

/**
 * @author dyu
 * @date 2018/09/09
 */
public class TargetImpl implements Target {
    @Override
    public void test() {
        System.out.println("target invoke ...");
    }
}
