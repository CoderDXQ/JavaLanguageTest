package com.example.designpatterns.factory.factory1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:39 下午
 */
//工厂方法模式 工厂类实现抽象工厂类，存在多个工厂，每个工厂做一种产品
public class Demo {
    public static void main(String[] args) {
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();
        appleFactory.makePhone();
    }
}
