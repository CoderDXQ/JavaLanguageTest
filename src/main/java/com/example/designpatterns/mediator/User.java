package com.example.designpatterns.mediator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:21 下午
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    //    将消息给中介者 中介者负责处理
    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

