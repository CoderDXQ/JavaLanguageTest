package com.example.designpatterns.nullobject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:24 下午
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}
