package com.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:12 下午
 */
//被观察类
public class Subject {

    //    观察者列表
    private List<Observer> observers = new ArrayList<>();
    //    被观察的属性字段
    private int state;

    public int getState() {
        return state;
    }

    //    状态更改时会通知所有的观察者
    public void setState(int state) {
        this.state = state;
//        通知所有观察者
        notifyAllObservers();
    }

    //    添加观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //    通知所有的观察者 执行更新
    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


}
