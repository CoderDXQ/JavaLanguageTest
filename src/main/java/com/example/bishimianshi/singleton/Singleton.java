package com.example.bishimianshi.singleton;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/31 9:41 下午
 */

//单例模式 双重校验锁
public class Singleton {

    //    私有的 静态的 volatile修饰
//    volatile的作用是禁止指令重排序
    private static volatile Singleton instance;

    //    构造方法
    public Singleton() {
    }

    public static Object getInstance() {
        if (instance == null) {
//            直接锁住class对象
            synchronized (Singleton.class) {
//                存在一种情况 两个进程同时争抢锁 一个线程完成创建单例后另一个线程拿到锁
//                如果不加下面的这个判断 单例就会被重复创建
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
