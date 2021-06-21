package com.example.designpatterns.bridge;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/21 10:39 下午
 */
//桥接器模式
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
