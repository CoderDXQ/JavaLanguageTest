package com.example.designpatterns.state;

//记录状态
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context() {
        this.state = null;
    }
}
