package com.example.designpatterns;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 9:15 下午
 */
//单例类只能有一个实例
//单例类必须自己创建自己唯一的实例
//单例类必须给其他所有对象提供这一实例

//    懒汉式 线程不安全
//    第一次调用才初始化，以后都不会再创建对象
public class Singleton {
    private static Singleton instance;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
