package com.example.jdk8.methodreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/31 11:41 下午
 */
public class Test1 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);


    }

}
