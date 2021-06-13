package com.example.designpatterns.observer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/13 11:29 下午
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }

}
