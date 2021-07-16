package com.example.designpatterns.interceptingFilter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/17 12:10 上午
 */
//定义过滤器接口
public interface Filter {
    public void execute(String request);
}
