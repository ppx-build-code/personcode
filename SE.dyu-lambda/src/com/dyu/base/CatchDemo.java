package com.dyu.base;

/**
 * @author dyu 2019.02.27
 */
public class CatchDemo {


    public int compute() {

        int a = 1;
        try {
            a = a / 0;
            return a;
        } catch (Exception e) {
            a = 5;
            return a;
        } finally {
            return a = a + 1;
        }
    }

    public static void main(String[] args) {
        int a = new CatchDemo().compute();
        System.out.println(a);
        a = a + 1;
        System.out.println(a);
    }
}
