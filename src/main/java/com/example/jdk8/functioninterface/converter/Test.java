package com.example.jdk8.functioninterface.converter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:25 下午
 */
public class Test {

    public static void main(String[] args) {
//        抽象接口的实现 函数式接口
        Converter<String,Integer> converter=from -> Integer.valueOf(from);
        Integer converted= converter.convert("123");
        System.out.println(converted.getClass());
        System.out.println(converted);
    }

}
