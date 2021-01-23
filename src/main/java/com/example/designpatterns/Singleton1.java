package com.example.designpatterns;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 9:12 下午
 */

//懒汉式  线程安全
//    第一次调用才初始化，以后都不会再创建对象
public class Singleton1 {
    private static Singleton1 instance;

    public Singleton1() {
    }

    //    加锁会影响效率，如果程序对该单例使用的很频繁，不建议使用这种写法
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
