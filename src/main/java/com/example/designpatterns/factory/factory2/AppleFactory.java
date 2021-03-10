package com.example.designpatterns.factory.factory2;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:38 下午
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public IPhone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return new MAC();
    }
}
