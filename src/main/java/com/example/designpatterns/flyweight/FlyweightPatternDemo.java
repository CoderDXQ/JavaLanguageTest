package com.example.designpatterns.flyweight;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/7 11:48 下午
 */
public class FlyweightPatternDemo {
    //    直接将字符串常量赋值给静态字符串数组
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}
