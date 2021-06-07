package com.example.jdk8.methodreferences.factory;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/6 10:45 下午
 */
//对象工厂接口
public interface PersonFactory<P extends Person> {
    //    抽象方法
    P create(String firstName, String lastName);
}
