package com.dyu.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dyu 2019/2/22
 */
public class HashMapPractice {

    public static void main(String[] args) {

        HashMap<Integer, String> ms = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            ms.put(i, String.valueOf(i+i));
        }

        ms.put(1231243, "helo");
        System.out.println("over...");

//        2
//        17
//        32
//        47
//        62
//        77
//        92
//        107
    }
}
