package com.example.designpatterns.nullobject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:23 下午
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
