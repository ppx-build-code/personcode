package com.dyu.base;

/**
 * @author dyu 2019.02.27
 */
public class LoadChilder extends LoadSuper {

    static {
        System.out.println("childer static model load...");
    }

    {
        System.out.println("childer normal model load ...");
    }

    public LoadChilder() {
        System.out.println("childer constructor load ...");
    }

    public static void helloWorld() {
        System.out.println("child static method load ...");
    }

    public void normal() {
        System.out.println("child normal method load ...");
    }

    public static void main(String[] args) {
        LoadSuper loadSuper = new LoadSuper();
        loadSuper.normal();
    }
}

