package com.example.designpatterns.singleton;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 10:04 下午
 */
//登记式，使用静态内部类实现 线程安全 利用了类加载机制

public class Singleton4 {
    private static class SingletonHolder {
        //final修饰后的类不能被继承，其属性和方法默认也被final修饰 final修饰的变量不可更改 final修饰的方法不能被重写 并且final修饰的方法可以被jvm转化为内联函数，从而提高效率
        private static final Singleton4 INSTANCE = new Singleton4();

    }

    public Singleton4() {
    }

    public static final Singleton4 getINSTANCE() {
//        只有显式调用get方法时才会加载SingletonHolder类
        return SingletonHolder.INSTANCE;
    }
}
