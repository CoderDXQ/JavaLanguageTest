package com.example.designpatterns.factory.factory2;

import com.example.designpatterns.factory.factory1.Phone;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:28 下午
 */
public class IPhone implements Phone {

    public IPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make iphone!");
    }
}
