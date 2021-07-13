package com.example.designpatterns.strategy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:47 下午
 */
//定义策略的接口类 具体的策略实现这个接口即可
public interface Strategy {
    public int doOperation(int num1, int num2);
}
