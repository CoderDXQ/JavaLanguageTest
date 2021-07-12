package com.example.designpatterns.memento;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:31 下午
 */
//备忘录管理类 负责抽取存放备忘录
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }


}
