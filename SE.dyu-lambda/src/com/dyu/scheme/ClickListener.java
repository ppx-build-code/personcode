package com.dyu.scheme;

import java.util.EventListener;

/**
 * @author dyu 2019.04.29
 */
public class ClickListener implements EventListener {

    public void onSingle(ClickEvent clickEvent) {
        System.out.println("鼠标单击");
    }

    public void onDouble(ClickEvent clickEvent) {
        System.out.println("鼠标双击");
    }
}
