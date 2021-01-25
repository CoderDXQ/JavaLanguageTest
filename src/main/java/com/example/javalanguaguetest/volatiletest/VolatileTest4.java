package com.example.javalanguaguetest.volatiletest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/26 1:39 上午
 */

//volatile可以保证变量的可见性 从而避免出现脏读问题
public class VolatileTest4 {

    static class A {
        int a = 0;
        //        volatile boolean flag = false;
        boolean flag = false;

        void writer() throws InterruptedException {
            //写线程改变变量的值之后不立即写回主存，此时只是线程的私存中变量的值发生了变化
            a = 1;
            flag = true;
            Thread.sleep(1);

            System.out.println("write down");
        }

        //        在写之前就进行了读 此时写的变量的更新值还没有写回主存就被读线程读取，就会出现脏读
        void reader() throws InterruptedException {
//            加上下面这一句就可以让写线程先执行，去掉则读线程可能先执行，两者输出的结果是不一样的
//            Thread.sleep(1000);

            if (flag) {

                int i = a;
                System.out.println("read flag : " + flag);
                System.out.println("i is : " + i);
            } else {
                int i = a;
                System.out.println("read flag : " + flag);
                System.out.println("i is : " + i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        A aaa = new A();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    aaa.reader();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            if (i == 0) {
                new Thread(() -> {
                    try {
                        aaa.writer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
//        Thread.sleep(100);

//        new Thread(() -> {
//            try {
//                aaa.writer();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        new Thread(() -> {
            try {
                aaa.reader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
