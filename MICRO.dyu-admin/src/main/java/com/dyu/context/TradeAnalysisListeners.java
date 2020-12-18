package com.dyu.context;

import com.google.common.util.concurrent.RateLimiter;

import java.util.EventObject;
import java.util.Vector;

/**
 * @author dyu 2019-08-07 20:22
 */
public class TradeAnalysisListeners {

    private Vector<ITradeAnalysisListener> ts;
    RateLimiter rateLimiter;

    public TradeAnalysisListeners() {
        rateLimiter = RateLimiter.create(5.0);
        ts = new Vector<>();
    }

    public void start() {

        for (int i = 0; i < ts.size(); i++) {
            ITradeAnalysisListener listener = ts.get(i);

            if (listener instanceof SimpleTradeAnalysisListener) {
                SimpleTradeAnalysisListener simple = (SimpleTradeAnalysisListener) listener;
                simple.handle(new TradeAnalysisEvent(rateLimiter, new RuntimeException("happen a exception.")));
            }
        }

    }

    public void add(ITradeAnalysisListener listener) {
        ts.add(listener);
    }


    public static void main(String[] args) {

        TradeAnalysisListeners analysis = new TradeAnalysisListeners();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long s = (long) (Math.random() * 100 % 2 * 1000);
                        System.out.println(Thread.currentThread().getName() + " - " +  s);
                        Thread.sleep(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    analysis.add(new SimpleTradeAnalysisListener());
                    analysis.start();
                }
            }, "线程" + i).start();
        }

    }
}
