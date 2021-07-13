package com.example.designpatterns.strategy;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:47 下午
 */
//策略容器 负责执行不同的策略
public class Context {
    private Strategy strategy;

    public Context() {
    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //    设置不同的策略
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
