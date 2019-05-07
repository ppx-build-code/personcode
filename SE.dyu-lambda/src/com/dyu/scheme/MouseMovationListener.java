package com.dyu.scheme;

import java.util.EventListener;

/**
 * @author dyu 2019.04.29
 */
public class MouseMovationListener implements EventListener {


    public void onLeftMovation(MouseMovationEvent mouseMovationEvent) {
        System.out.println("鼠标左移");
    }

    public void onRightMovation(MouseMovationEvent mouseMovationEvent) {
        System.out.println("鼠标右移");
    }
}
