package com.example.designpatterns.factory.factory;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:31 下午
 */

//简单工厂模式 只有一个工厂，一个工厂可以生产多个产品，多个产品实现抽象产品类
public class Demo {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("MiPhone");
        Phone iPhone = factory.makePhone("iPhone");
    }
}
