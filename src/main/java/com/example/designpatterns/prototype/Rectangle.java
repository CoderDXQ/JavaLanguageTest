package com.example.designpatterns.prototype;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/19 11:32 下午
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
