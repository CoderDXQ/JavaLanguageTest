package com.example.designpatterns.observer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:27 下午
 */
public class OctalObserver extends Observer {

    //    在观察者的构造方法中将本观察者添加到被观察者的观察者列表中
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
