package com.example.javalanguaguetest.multithread;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/28 9:56 上午
 */


//通过扩展Thread类创建线程
class MultithreadingDemo extends Thread {
    public void run() {
        try {
            System.out.println("Thread" + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception is caught");
        }
    }
}


public class CreatThreadMethods_Thread {
    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 8; i++) {
            MultithreadingDemo object = new MultithreadingDemo();
            object.start();//会自动执行run()方法
        }
    }
}
