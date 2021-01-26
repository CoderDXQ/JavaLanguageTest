package com.example.javalanguaguetest.reflection.forname.forNameTest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 11:38 下午
 */
public class User {
    private static int a = 10;

    {
        System.out.println("普通代码块");
    }

    static {
        System.out.println("静态变量a: " + a);
        System.out.println("静态代码块");
    }
}
