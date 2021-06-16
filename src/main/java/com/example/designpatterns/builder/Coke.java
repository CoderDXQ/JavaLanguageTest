package com.example.designpatterns.builder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:25 下午
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
