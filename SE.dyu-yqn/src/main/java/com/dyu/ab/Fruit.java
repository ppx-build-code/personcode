package com.dyu.ab;

/**
 * @author dyu 2020/2/18 18:23
 */
public abstract class Fruit {

    public abstract boolean isRealtime();

    public void test() {
        System.out.println(isRealtime());
    }

    public static void main(String[] args) {
        Fruit fruit = new FruitSecond();
        fruit.test();
    }
}
