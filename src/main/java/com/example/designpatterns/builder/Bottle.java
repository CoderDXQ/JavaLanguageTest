package com.example.designpatterns.builder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:18 下午
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
