package com.dyu.demo;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;

/**
 * @author dyu 2020/12/17 23:49
 */
public class SecSkillEventProducer {
    private final static EventTranslatorVararg<SecondSkillEvent> translator = new EventTranslatorVararg<SecondSkillEvent>() {
        public void translateTo(SecondSkillEvent secondSkillEvent, long l, Object... objects) {
            secondSkillEvent.setProductId((Long) objects[0]);
            secondSkillEvent.setUserId((Long) objects[1]);
        }
    };


    private final RingBuffer<SecondSkillEvent> ringBuffer;


    public SecSkillEventProducer(RingBuffer<SecondSkillEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void secSkill(long skillId, long userId) {
        this.ringBuffer.publishEvent(translator, skillId, userId);
    }
}
