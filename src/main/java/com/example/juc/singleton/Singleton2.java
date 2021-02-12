package com.example.juc.singleton;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 9:13 下午
 */

//饿汉式
//    没有锁，执行效率高  类加载时就进行初始化，浪费内存 但是线程安全
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    public Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
