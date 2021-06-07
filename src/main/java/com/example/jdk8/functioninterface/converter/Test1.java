package com.example.jdk8.functioninterface.converter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:38 下午
 */
public class Test1 {

    public static void main(String[] args) {
        Converter<String,Integer> convert=Integer::valueOf;
        System.out.println(convert.convert("345"));
        System.out.println(convert.getClass());
    }

}
