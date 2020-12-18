package com.dyu.base;

/**
 * @author dyu 2019.02.27
 */
public class StaticBindDemo {

    public void attach(int val) {
        System.out.println("int attach val -> " + val);
    }

    public void attach(String val) {
        System.out.println("string attach val -> " + val);
    }

    public void attach(Integer val) {
        System.out.println("integer attach val -> " + val);
    }

    public void attach(short val) {
        System.out.println("short attach val -> " + val);
    }

    public void attach(Short val) {
        System.out.println("Short attach val -> " + val);
    }

    public void attach(Long val) {
        System.out.println("Long attach val -> " + val);
    }

    public void attach(long val) {
        System.out.println("long attach val -> " + val);
    }

    public void attach(Byte val) {
        System.out.println("Byte attach val -> " + val);
    }

    public void attach(byte val) {
        System.out.println("byte attach val -> " + val);
    }

    public void attach(Character val) {
        System.out.println("Character attach val -> " + val);
    }

    public void attach(char val) {
        System.out.println("char attach val -> " + val);
    }

    public void attach(Double val) {
        System.out.println("Double attach val -> " + val);
    }

    public void attach(double val) {
        System.out.println("double attach val -> " + val);
    }

    public void attach(Float val) {
        System.out.println("Float attach val -> " + val);
    }

    public void attach(float val) {
        System.out.println("float attach val -> " + val);
    }

    public void attach(Boolean val) {
        System.out.println("Boolean attach val -> " + val);
    }

    public void attach(boolean val) {
        System.out.println("boolean attach val -> " + val);
    }

    public static void main(String[] args) {
        StaticBindDemo bind = new StaticBindDemo();
        bind.attach(1);
        bind.attach(123123123);
        bind.attach(123L);
        bind.attach(0);
        bind.attach("1");
        bind.attach('1');
    }
}
