package com.example.javalanguaguetest.callback.two_writing_method_of_callback1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 2:18 上午
 */


//这个包里是接口单独写的CallBack的实现
public class Test {
    public static void main(String[] args) {
        Wang wang = new Wang(new Li());
        wang.askQuestion(1000);
    }
}
