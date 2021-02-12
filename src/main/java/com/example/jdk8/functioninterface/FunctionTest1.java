package com.example.jdk8.functioninterface;

import java.util.function.Function;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/8 11:59 下午
 */
//函数式接口：只有一个类型的接口
public class FunctionTest1 {

    public static void main(String[] args) {

//        尖括号里左边是入参类型，右边是出参类型
        Function<Integer, String> function = (num) -> {
            return String.valueOf(num);
        };

//        查看返回值类型是否是String
        System.out.println(function.apply(888).getClass().equals(String.class));
        System.out.println(function.apply(888));
    }
}
