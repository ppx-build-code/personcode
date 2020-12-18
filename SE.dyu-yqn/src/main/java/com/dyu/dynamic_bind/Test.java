package com.dyu.dynamic_bind;

import java.io.Serializable;

/**
 * @author dyu 2020/4/11 22:18
 */
public class Test {


    public static <T extends ClassOne> T getClassOne() {
        return null;
    }

    public static <T extends InterfaceOne> T getInterfaceOne() {
        return null;
    }

    public static void printType(Object o) {
        System.out.println("genericPrint");
    }

    public static <T extends ClassTwo> void printType(T o) {
        System.out.println("T is class two");
    }

    public static void main(String[] args) {
        ClassOne a = getClassOne();
        InterfaceOne b = getInterfaceOne();

        printType(getClassOne());
        printType(getInterfaceOne());
        printType(a);
        printType(b);

        System.out.println((ClassOne)getInterfaceOne());
    }
}
