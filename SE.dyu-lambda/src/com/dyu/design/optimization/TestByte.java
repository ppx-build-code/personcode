package com.dyu.design.optimization;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author dyu
 * @date 2018/09/11
 */
public class TestByte {
    public static void main(String[] args) {
        //byte[] b1,b2,b3,b4;//定义变量
        //b1=new byte[1024*512];//分配 1MB 堆空间，考察堆空间的使用情况
        //b2=new byte[1024*1024];
        //b3=new byte[1024*1024*5];
        //b3 = null;
        //b4=new byte[1024*1024];

        int [] a = {3,4,1,5,3,5,6,9,4,6,33,56,1};

        int temp = 0 ;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        Arrays.asList(a).parallelStream().map(String::valueOf).forEach(System.out::println);

        for (int k = 0; k < a.length; k ++ ) {
            System.out.println(k);
        }
    }
}
