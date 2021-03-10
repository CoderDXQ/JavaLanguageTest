package com.example.designpatterns.factory.factory;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 11:29 下午
 */
public class PhoneFactory {
    public Phone makePhone(String phoneType) {
        if (phoneType.equalsIgnoreCase("MiPhone")) {
            return new MiPhone();
        } else if (phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }
}
