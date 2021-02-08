package com.example.juc.newcharacterofjdk8.functioninterface;

import java.util.function.Consumer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:36 上午
 */
public class ConsumerTest1 {

    public static void main(String[] args) {

//        只有一个入参
        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("aaa");
    }
}
