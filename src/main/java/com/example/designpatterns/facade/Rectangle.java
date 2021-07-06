package com.example.designpatterns.facade;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/6 11:17 下午
 */
//接口的实现类
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
