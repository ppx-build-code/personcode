package com.dyu;

import com.dyu.demo.SecSkillConsumer;
import com.dyu.demo.SecSkillEventProducer;
import com.dyu.demo.SecSkillFactory;
import com.dyu.demo.SecondSkillEvent;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World! start ...");
        producerWithTranslator();
    }

    public static void producerWithTranslator() {
        SecSkillFactory secSkillFactory = new SecSkillFactory();
        int ringBuffer = 1024;
        ThreadFactory threadFactory = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r, "dyu" + Math.random());
            }
        };
        Disruptor<SecondSkillEvent> disruptor = new Disruptor<SecondSkillEvent>(secSkillFactory, ringBuffer, threadFactory);
        disruptor.handleEventsWith(new SecSkillConsumer());
        disruptor.start();
        RingBuffer<SecondSkillEvent> ringBuffer1 = disruptor.getRingBuffer();
        SecSkillEventProducer producer = new SecSkillEventProducer(ringBuffer1);
        for (int i = 0; i < 10; i++) {
            producer.secSkill(i, i << i);
        }
        disruptor.shutdown();
    }
}
