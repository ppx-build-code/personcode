package com.dyu.scheme;

import java.util.EventListener;

/**
 * @author dyu 2019.04.29
 */
public class LoadPageListener implements EventListener {


    public void onSuccess(LoadPageEvent loadPageEvent) {
        System.out.println("事件加载成功");
    }

    public void onError(LoadPageEvent loadPageEvent) {
        System.out.println("事件加载异常");
    }

    public void onStart(LoadPageEvent loadPageEvent) {
        System.out.println("事件开始加载");
    }

    public void onClose(LoadPageEvent loadPageEvent) {
        System.out.println("事件加载结束");
    }
}
