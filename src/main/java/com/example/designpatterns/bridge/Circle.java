package com.example.designpatterns.bridge;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/21 10:35 下午
 */
//桥接器 可以连接DrawAPI的实现类
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
