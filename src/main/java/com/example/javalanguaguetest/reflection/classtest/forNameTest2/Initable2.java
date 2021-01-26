package com.example.javalanguaguetest.reflection.classtest.forNameTest2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 2:33 上午
 */
public class Initable2 {
//    不是编译期常量
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}
