package com.example.javalanguaguetest.getenv;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/16 2:56 下午
 */
public class GetEnv {
    public static void main(String[] args) {
        //设置环境变量
        String INCLUDE=System.getenv("PATH");
        System.out.println(INCLUDE);
    }
}
