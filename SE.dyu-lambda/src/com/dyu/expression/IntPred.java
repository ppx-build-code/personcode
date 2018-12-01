package com.dyu.expression;

import java.awt.*;
import java.util.function.Predicate;

interface IntPred {
    //boolean test(Integer value);


    boolean test(Predicate<Integer> predicate);

    //boolean check(IntPred intPred);


    static void main(String[] args) {
        IntPred intPred = x -> {
            return x.test(5);
        };

        System.out.println(6^4);
    }
}
