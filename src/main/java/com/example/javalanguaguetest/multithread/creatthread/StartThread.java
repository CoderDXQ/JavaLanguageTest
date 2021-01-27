package com.example.javalanguaguetest.multithread.creatthread;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 7:45 下午
 */

class T1 implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                //可以通过控制线程的休眠时间来影响并发结果
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T2 implements Runnable {
    public void run() {
        try {
            for (int i = 0; i > -10; i--) {
                System.out.println(i);
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class StartThread {


    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
//调用run()方法只能是单纯的调用方法，不能实现并发
        t1.run();
        t2.run();
        System.out.println("\n");

//只有调用start()方法才可以启动线程，run()只是个普通方法
        t1.start();
        t2.start();
        System.out.println("\n");

        while (t1.isAlive()) {
        }
        while (t2.isAlive()) {
        }

    }

}
