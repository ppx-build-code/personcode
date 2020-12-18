package com.dyu.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Moon {
    private final List<LandingObserver> observers;

    public Moon() {
        observers = new ArrayList<>();
    }

    public void land(String name) {
        observers.forEach(i -> i.observerLanding(name));
    }

    public void startSpying(LandingObserver landingObserver) {
        observers.add(landingObserver);
    }

    public static void main(String[] args) {
        Moon moon = new Moon();

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("we made it!");
            }
        });

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("They're distracted, lets invade earth!");
            }
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }
}
