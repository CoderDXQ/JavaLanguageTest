package com.example.designpatterns.bridge;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/21 10:28 下午
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x:" + x + ", " + y + "]");
    }
}
