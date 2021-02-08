package com.example.juc.newcharacterofjdk8.functioninterface;

import java.util.function.Predicate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:22 上午
 */
public class PredicateTest1 {

    public static void main(String[] args) {

//        只有一个入参，返回值是布尔型
        Predicate<Integer> predicate = (num) -> {
            return num > 0;
        };

        System.out.println(predicate.test(10));
        System.out.println(predicate.test(0));
        System.out.println(predicate.test(-5));
    }
}
