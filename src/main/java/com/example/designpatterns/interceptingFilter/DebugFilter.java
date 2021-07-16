package com.example.designpatterns.interceptingFilter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:12 上午
 */
//日志过滤器
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}
