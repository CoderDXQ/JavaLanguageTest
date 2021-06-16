package com.example.designpatterns.builder;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/16 10:16 下午
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}
