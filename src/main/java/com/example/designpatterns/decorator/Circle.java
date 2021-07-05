package com.example.designpatterns.decorator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/5 10:51 下午
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
