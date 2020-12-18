package com.dyu.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu 2019.02.25
 */
public class ObserverPatternDemo {

    public static class Subject {
        public List<Observer> observerList = new ArrayList<>();
        private int state;

        public List<Observer> getObserverList() {
            return observerList;
        }

        public void attach(Observer observer) {
            this.observerList.add(observer);
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            for (Observer observer : observerList) {
                observer.update();
            }
        }
    }

    public static abstract class Observer {
        protected Subject subject;
        public abstract void update();
    }

    public static class BinaryObserver extends Observer{

        public BinaryObserver(Subject subject) {
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("binary observer is update, val -> " + Integer.toBinaryString(subject.state));
        }
    }

    public static class OctalObserver extends Observer {

        public OctalObserver(Subject subject) {
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("octal observer is update, val -> " + Integer.toOctalString(subject.state));
        }
    }

    public static class HexaObserver extends Observer {

        public HexaObserver(Subject subject) {
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("hexa observer is update, val -> " + Integer.toHexString(subject.state));
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        subject.setState(15);

    }
}
