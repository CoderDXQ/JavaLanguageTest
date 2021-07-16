package com.example.designpatterns.frontController;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/16 11:46 下午
 */
//创建视图
public class HomeView implements View {
    @Override
    public void show() {
        System.out.println("Displaying Home Page");
    }
}
