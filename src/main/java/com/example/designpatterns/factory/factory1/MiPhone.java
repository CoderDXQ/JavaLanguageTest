package com.example.designpatterns.factory.factory1;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:26 下午
 */
public class MiPhone implements Phone {
    //    在构造函数中调用重写的方法
    public MiPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi phone!");
    }
}
