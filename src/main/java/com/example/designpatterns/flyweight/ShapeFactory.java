package com.example.designpatterns.flyweight;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/7 11:42 下午
 */
//创建一个工厂 生成基于给定信息的实体类的对象
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    //    在这个工厂类中通过这个方法获取元素
    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

//        如果没有就新建然后储存起来
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
