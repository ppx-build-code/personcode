package com.dyu.expression;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author dyu
 * @date 2018/07/07
 */
public class MoreExpression {

    Runnable noArguments = () -> System.out.println("hello world");

    ActionListener oneArgument = event -> System.out.println("button clicked");

    Runnable multiStatement = () -> {
        System.out.println("Hello");
        System.out.println(" World");
    };

    BinaryOperator<Long> add = (x, y) -> x + y;

    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;


    Predicate<Integer> atLeast5 = x -> x > 5;

    BinaryOperator<Long> addLongs = (x, y) -> x + y;

    public static void main(String[] args) {
        new MoreExpression().noArguments.run();

        JButton jButton = new JButton();
        jButton.addActionListener(even -> {
            System.out.println(even.getActionCommand());
        });
    }
}
