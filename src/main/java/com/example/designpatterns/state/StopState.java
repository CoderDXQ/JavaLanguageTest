package com.example.designpatterns.state;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
//        context里面有一个State StopState是实现了State
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
