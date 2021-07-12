package com.example.designpatterns.state;

import lombok.val;

public class StatePatternDemo {
    public static void main(String[] args) {
//        Context用于记录状态
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
