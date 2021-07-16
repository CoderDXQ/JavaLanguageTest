package com.example.designpatterns.frontController;

import com.fasterxml.jackson.databind.BeanProperty;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 11:47 下午
 */
//视图调度器 用于调度视图
public class Dispatcher {

    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        this.studentView = new StudentView();
        this.homeView = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }

}
