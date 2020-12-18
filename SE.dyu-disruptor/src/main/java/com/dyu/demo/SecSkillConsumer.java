package com.dyu.demo;


import com.lmax.disruptor.EventHandler;

/**
 * @author dyu 2020/12/17 23:43
 */
public class SecSkillConsumer implements EventHandler<SecondSkillEvent> {

    public void onEvent(SecondSkillEvent secondSkillEvent, long l, boolean b) throws Exception {
        System.out.println("thread" + Thread.currentThread().getName() + ", consumer >>>>>>>> " + secondSkillEvent.toString());
    }
}
