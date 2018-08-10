package com.dyu.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author dyu
 * @date 2018/08/10
 */
public class HappyNumber {

    /**
     * 编写一个算法来判断一个数是不是“快乐数”。
     * <p>
     * 一个“快乐数”定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
     * 如果可以变为 1，那么这个数就是快乐数。
     */

    public static boolean isHapply(int n) {
        if (n <= 0) {
            return false;
        }

        Set<Integer> results = new HashSet<>();

        int tempN = n;

        while (true) {
            char[] ns = Integer.valueOf(tempN).toString().toCharArray();
            tempN = 0;
            for (char n1 : ns) {
                tempN += (Integer.valueOf(String.valueOf(n1)) * Integer.valueOf(String.valueOf(n1)));
            }
            if (tempN == 1 || tempN == 10 || Math.sqrt(Double.valueOf(String.valueOf(tempN))) == 10) {
                return true;
            }
            if (results.contains(tempN)) {
                return false;
            }
            results.add(tempN);
        }
    }

    /**
     * 4ms
     * @param n
     * @return
     */
    public static boolean isHapply1(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int tmp = 0;
            while (n > 0) {
                tmp = tmp + (int) Math.pow(n % 10, 2);
                n = n/10;
            }
            n = tmp;
            if(set.contains(n)) break;
            else set.add(n);
        }
        return n == 1;
    }

    /**
     *  1ms
     * @param n
     * @return
     */
    public static boolean isHapply2(int n) {
        if (n ==1)
            return true;
        int result = 0;
        while (true) {
            while (n > 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (result == 1) {
                return true;
            } else if (result == 4) {
                return false;
            } else {
                n = result;
                result = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.isHapply(8266));
        //System.out.println(Math.sqrt(140));
    }
}
