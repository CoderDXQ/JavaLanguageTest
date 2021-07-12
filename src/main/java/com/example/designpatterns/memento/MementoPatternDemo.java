package com.example.designpatterns.memento;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:35 下午
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTeker careTeker = new CareTeker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTeker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTeker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTeker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTeker.get(1));
        System.out.println("Second saved State: " + originator.getState());

    }
}
