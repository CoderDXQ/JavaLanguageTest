package com.example.designpatterns.facade;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/6 11:22 下午
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
