package com.example.javalanguaguetest.multithread;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/30 1:35 上午
 */
public class Join implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Join(), "线程1:");
        Thread thread2 = new Thread(new Join(), "线程2:");
        Thread thread3 = new Thread(new Join(), "线程3:");

        thread1.start();
//        thread1.join();
        thread2.start();
//        thread2.join();
        thread3.start();
//        thread3.join();

//三个子线程是并发执行的，join()方法是等待某个线程死亡再往下执行
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("-------------主线程到此为止————————————————————");


        for (int i = 0; i < 20; i++) {
            System.out.println("主线程" + i);
        }

    }

}
