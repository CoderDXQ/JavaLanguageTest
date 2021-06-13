package com.example.designpatterns.observer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:16 下午
 */
public abstract class Observer {
    protected Subject subject;

    //    定义抽象方法
    public abstract void update();
}
