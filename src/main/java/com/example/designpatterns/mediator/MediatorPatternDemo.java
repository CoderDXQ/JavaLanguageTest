package com.example.designpatterns.mediator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:24 下午
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
