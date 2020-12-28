package com.dyu.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author dyu 2020/12/28 09:36
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new HashedWheelTimer();

        Timeout timeout1 = timer.newTimeout(new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout1 start.");
            }
        }, 2, TimeUnit.SECONDS);
        if (!timeout1.isExpired()) {
            timeout1.cancel();
        }

        Timeout timeout2 = timer.newTimeout(new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout2 start.");
                Thread.sleep(5000);
            }
        }, 2, TimeUnit.SECONDS);
        Timeout timeout3 = timer.newTimeout(new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout3 start.");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
