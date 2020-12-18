package com.dyu.design.observer;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Nasa implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.equals("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
