package com.dyu.base;

/**
 * @author dyu 2019.02.27
 */
public class LoadSuper {
    static {
        System.out.println("super static model load...");
    }

    {
        System.out.println("super normal model load ...");
    }

    public LoadSuper() {
        System.out.println("super constructor load ...");
    }

    public static void helloWorld() {
        System.out.println("super static method load ...");
    }

    public void normal() {
        System.out.println("super normal method load ...");
    }

}
