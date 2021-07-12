package com.example.designpatterns.mediator;


import java.util.Date;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/12 8:20 下午
 */
//这是个中介类
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
