package com.dyu.context;

/**
 * @author dyu 2019-08-07 20:32
 */
public class SimpleTradeAnalysisListener implements ITradeAnalysisListener {


    @Override
    public void handle(TradeAnalysisEvent event) {
        event.start();
    }
}
