package com.example.jdk8.lambda;

import com.example.jdk8.functioninterface.converter.Converter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:52 下午
 */
//Lamda表达式的作用域
public class LambdaScopes {

    public static void main(String[] args) {
//        这里有隐藏的final修饰
        int num = 1;
//        from是Integer to是String
        Converter<Integer, String> stringConverter = from -> String.valueOf(from
                + num);

        System.out.println(stringConverter.convert(2));
        System.out.println(stringConverter.convert(2).getClass());

//        加上这一句会有下面的报错 说明num变量有隐藏的final修饰
//        java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
//        num = 3;

    }

}
