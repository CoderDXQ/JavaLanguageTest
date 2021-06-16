package com.example.designpatterns.builder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:19 下午
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
