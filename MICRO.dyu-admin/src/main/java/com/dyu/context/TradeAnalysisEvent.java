package com.dyu.context;

import com.google.common.util.concurrent.RateLimiter;

import java.util.EventObject;

/**
 * @author dyu 2019-08-07 20:11
 */
public class TradeAnalysisEvent extends EventObject {

    private RateLimiter rateLimiter;
    private Exception exception;


    public TradeAnalysisEvent(RateLimiter rateLimiter, Exception e) {
        super(e);
        this.rateLimiter = rateLimiter;
        this.exception = e;
    }

    public void start() {
        boolean b = rateLimiter.tryAcquire();
        if (!b) {
            throw new RuntimeException(Thread.currentThread().getName() + " error.");
        }
    }
}
