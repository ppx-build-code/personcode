package com.dyu.scheme;

import java.util.EventObject;

/**
 * @author dyu 2019.04.29
 */
public class Page {


    private ClickListener clickListener;
    private MouseMovationListener mouseMovationListener;
    private LoadPageListener loadPageListener;

    public void addClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void addMouseMovationListener(MouseMovationListener mouseMovationListener) {
        this.mouseMovationListener = mouseMovationListener;
    }

    public void addLoadPageListener(LoadPageListener loadPageListener) {
        this.loadPageListener = loadPageListener;
    }

    public void trigger(EventObject eventObject) {

        if (eventObject instanceof ClickEvent) {
            ClickEvent clickEvent = (ClickEvent) eventObject;
            switch (clickEvent.getId()) {
                case ClickEvent.SINGLE_CLICK: clickListener.onSingle(clickEvent); break;
                case ClickEvent.DOUBLE_CLICK: clickListener.onDouble(clickEvent); break;
            }
        } else if (eventObject instanceof LoadPageEvent) {
            LoadPageEvent loadPageEvent = (LoadPageEvent) eventObject;
            switch (loadPageEvent.getId()) {
                case LoadPageEvent.PAGELOAD_SUCCESS: loadPageListener.onSuccess(loadPageEvent); break;
                case LoadPageEvent.PAGELOAD_CLOSE: loadPageListener.onClose(loadPageEvent); break;
                case LoadPageEvent.PAGELOAD_START: loadPageListener.onStart(loadPageEvent); break;
                case LoadPageEvent.PAGELOAD_ERROR: loadPageListener.onError(loadPageEvent); break;
            }
        } else if (eventObject instanceof MouseMovationEvent) {
            MouseMovationEvent mouseMovationEvent = (MouseMovationEvent) eventObject;
            switch (mouseMovationEvent.getId()) {
                case MouseMovationEvent.LEFT_MOVATION: mouseMovationListener.onLeftMovation(mouseMovationEvent); break;
                case MouseMovationEvent.RIGHT_MOVATION: mouseMovationListener.onRightMovation(mouseMovationEvent); break;
            }
        }
    }


    public static void main(String[] args) {
        Page page = new Page();
        page.addClickListener(new ClickListener());
        page.addLoadPageListener(new LoadPageListener());
        page.addMouseMovationListener(new MouseMovationListener());


        page.trigger(new ClickEvent(2, 2));
    }

}
