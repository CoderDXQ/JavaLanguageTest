package com.example.jdk8.methodreferences;

import com.example.jdk8.functioninterface.converter.Converter;
import lombok.val;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:41 下午
 */
public class TestSomething {

    public static void main(String[] args) {
        val something = new Something();
        Converter<String, String> converter = something::startWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
        System.out.println(converted.getClass());
    }

}
