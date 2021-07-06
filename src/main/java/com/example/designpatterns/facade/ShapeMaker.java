package com.example.designpatterns.facade;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/6 11:19 下午
 */
//外观类 这个类将三种实现合一 这样对外就只需要暴露一个接口
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Circle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

}
