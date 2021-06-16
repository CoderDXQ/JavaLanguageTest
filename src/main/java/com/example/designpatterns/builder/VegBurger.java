package com.example.designpatterns.builder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:23 下午
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
