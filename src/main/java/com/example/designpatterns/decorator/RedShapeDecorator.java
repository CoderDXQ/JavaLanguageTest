package com.example.designpatterns.decorator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/5 10:55 下午
 */
//装饰器的实现类
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
