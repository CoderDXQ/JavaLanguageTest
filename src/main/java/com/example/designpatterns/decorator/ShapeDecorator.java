package com.example.designpatterns.decorator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/5 10:52 下午
 */
//抽象装饰类
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    //    在构造方法中传入装饰器
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    //    调用的是传入的装饰器的draw方法
    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
