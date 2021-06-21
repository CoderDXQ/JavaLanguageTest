package com.example.designpatterns.bridge;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/21 10:32 下午
 */
//使用DrawAPI接口创建抽象类Shape 谁实现Shape谁就是桥接器
//    Shape可以用来连接DrawAPI的实现类
public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
