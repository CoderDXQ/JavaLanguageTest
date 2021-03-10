package com.example.designpatterns.factory.factory2;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:35 下午
 */
public interface AbstractFactory {
    //    声明抽象工厂的方法
    Phone makePhone();

    PC makePC();
}
