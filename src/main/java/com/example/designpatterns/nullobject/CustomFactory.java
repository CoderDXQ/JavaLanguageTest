package com.example.designpatterns.nullobject;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/7/13 11:25 下午
 */
public class CustomFactory {
    public static final String[] names = {"Rob", "Joe", "Julie"};

    //    在这个工厂类中进行判断并返回合适的实例
    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
