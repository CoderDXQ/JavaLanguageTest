package com.example.javalanguaguetest.callback.two_writing_method_of_callback2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 2:34 上午
 */
public class Test {
    public static void main(String[] args) {
        Wang wang = new Wang(new Li());
        wang.askQuestion(1000);
    }
}
