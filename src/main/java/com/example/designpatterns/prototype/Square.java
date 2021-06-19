package com.example.designpatterns.prototype;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/19 11:34 下午
 */
public class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    public Square() {
        type = "Square";
    }
}
