package com.example.designpatterns.prototype;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/19 11:36 下午
 */
public class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    public Circle() {
        type = "Circle";
    }
}

