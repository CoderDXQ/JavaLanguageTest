package com.example.designpatterns;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 9:12 下午
 */

//双重校验锁  安全，且在多线程下可以保证高性能
//    双重锁是volatile和synchronized
public class Singleton3 {
    //    加上volatile关键字  声明变量可见性
    private volatile static Singleton3 instance;

    public Singleton3() {
    }

    public static Singleton3 getInstance() {
//        需要创建实例  减少不必要的同步，优化性能
        // 只能有一个线程创建实例，单例模式只允许一个实例存在
        if (instance == null) {
            synchronized (Singleton3.class) {//加锁，线程安全
                if (instance == null) {//创建实例
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
