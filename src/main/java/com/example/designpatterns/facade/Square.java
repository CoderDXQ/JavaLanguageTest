package com.example.designpatterns.facade;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/6 11:18 下午
 */
//接口的实现类
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
