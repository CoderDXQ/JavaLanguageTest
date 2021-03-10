package com.example.designpatterns.factory.factory2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:43 下午
 */
public class MiPC implements PC {

    public MiPC() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi PC!");
    }
}
