package com.example.designpatterns.observer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:18 下午
 */
public class BinaryObserver extends Observer {

    //    在观察者的构造方法中将本观察者添加到被观察者的观察者列表中
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }

}
