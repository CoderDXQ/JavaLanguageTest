package com.example.juc.volatiletest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 1:24 上午
 */


//volatile可以保证变量的可见性 从而避免出现脏读问题
public class VolatileTest3 {

    //    这是一个静态内部类
    private static class Work {
        //如果不加volatile在控制台输出shutdown之后会继续输出dowork，说明isShutdown的更新值没有及时被其他线程获取，出现了脏读现象
//        volatile boolean isShutdown = false;
        boolean isShutdown = false;

        void shutdown() {
            isShutdown = true;
            System.out.println(Thread.currentThread() + " shutdown!");
        }

        void dowork() {
            while (!isShutdown) {
                System.out.println(Thread.currentThread() + " dowork");
            }
        }

    }

    public static void main(String[] args) {
        Work work = new Work();

//        启动线程
        new Thread(work::dowork).start();
        new Thread(work::dowork).start();
        new Thread(work::dowork).start();
        new Thread(work::dowork).start();
//        发布终止工作的命令
        new Thread(work::shutdown).start();
        new Thread(work::dowork).start();
        new Thread(work::dowork).start();
        new Thread(work::dowork).start();

    }
}
