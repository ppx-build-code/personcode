package com.dyu.context;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author dyu 2019-08-07 20:22
 */
public interface ITradeAnalysisListener extends EventListener {

    void handle(TradeAnalysisEvent event);
}
