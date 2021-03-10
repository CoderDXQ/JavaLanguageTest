package com.example.designpatterns.factory.factory2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:50 下午
 */
//抽象工厂模式 一个工厂可以生产多个产品，生产这些产品的方法定义在抽象工厂接口类中
public class Demo {

    public static void main(String[] args) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();
        miFactory.makePC();
        appleFactory.makePhone();
        appleFactory.makePC();
    }
}
