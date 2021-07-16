package com.example.designpatterns.interceptingFilter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:13 上午
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
