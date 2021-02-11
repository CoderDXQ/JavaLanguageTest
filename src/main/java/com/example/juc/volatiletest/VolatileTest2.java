package com.example.juc.volatiletest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 9:12 下午
 */


//volatile可以保证有序性，防止指令重排

//双重校验锁  安全，且在多线程下可以保证高性能
//    双重锁是volatile和synchronized
public class VolatileTest2 {
    //    加上volatile关键字  保证可见性和禁止指令重排序
//    new Singleton3()是一个非原子操作（申请内存 初始化 赋值），编译器可能会进行重排序即构造函数在整个对象初始化完成前执行完毕（赋值操作在初始化对象完成前，复制操作只是在内存开出一片存储区域然后直接返回内存的引用）。
//    此时，如果线程B在线程A赋值完但是初始化没进行完时进行判断，那么线程B将拿到一个没有初始化的半成品
//    另外，如果线程A在自己的工作线程创建了实例，但是此时还未同步到主存中，那么此时线程B在主存中判断instance还是null，那么此时线程B将再创建一个实例，此时已经不是单例模式了
//    https://blog.csdn.net/u010255818/article/details/65633033
    private volatile static VolatileTest2 instance;

    public VolatileTest2() {
    }

    public static VolatileTest2 getInstance() {
//        需要创建实例  减少不必要的同步，优化性能
        // 只能有一个线程创建实例，单例模式只允许一个实例存在
        if (instance == null) {
            synchronized (VolatileTest2.class) {//加锁，线程安全
                if (instance == null) {//创建实例
                    instance = new VolatileTest2();
                }
            }
        }
        return instance;
    }
}
