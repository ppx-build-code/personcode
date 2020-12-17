package com.dyu.demo;

import com.lmax.disruptor.EventFactory;

/**
 * @author dyu 2020/12/17 23:42
 */
public class SecSkillFactory implements EventFactory<SecondSkillEvent> {
    public SecondSkillEvent newInstance() {
        return new SecondSkillEvent();
    }
}
