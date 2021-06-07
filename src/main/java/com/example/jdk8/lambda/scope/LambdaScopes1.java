package com.example.jdk8.lambda.scope;

import com.example.jdk8.functioninterface.converter.Converter;
import lombok.val;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 11:10 下午
 */
public class LambdaScopes1 {

    //    外部静态变量
    static int outerStaticNum;
    int outerNum;

    //    lamda表达式对静态变量和实例字段都有读写访问权限
//    void testScope() {

    Converter<Integer, String> stringConverter = from -> {
        outerNum = 23;
        return String.valueOf(from);
    };

    Converter<Integer, String> stringConverter1 = from -> {
        outerStaticNum = 72;
        return String.valueOf(from);
    };

//    }

    public static void main(String[] args) {
        val lambdaScopes1 = new LambdaScopes1();
//        lambdaScopes1.testScope();
        System.out.println(lambdaScopes1.stringConverter.convert(66));
    }

}
