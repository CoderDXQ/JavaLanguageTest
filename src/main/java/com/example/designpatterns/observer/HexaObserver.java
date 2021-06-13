package com.example.designpatterns.observer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:28 下午
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
//        在观察者的构造方法中将本观察者添加到被观察者的观察者列表中
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
