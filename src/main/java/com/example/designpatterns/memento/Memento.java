package com.example.designpatterns.memento;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:29 下午
 */
//备忘录元素
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
