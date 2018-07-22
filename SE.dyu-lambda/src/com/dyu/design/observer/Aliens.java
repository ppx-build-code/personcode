package com.dyu.design.observer;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Aliens implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.equals("Apollo")) {
            System.out.println("They're distracted, lets invade earth");
        }
    }
}
