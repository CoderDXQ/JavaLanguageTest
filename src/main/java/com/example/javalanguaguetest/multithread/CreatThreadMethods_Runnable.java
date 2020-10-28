package com.example.javalanguaguetest.multithread;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/28 10:08 上午
 */
//通过Runnable接口创建线程
public class CreatThreadMethods_Runnable {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < 8; i++) {
            Thread object = new Thread(new MultithreadingDemo1());//传入实现Runnable接口的类
            object.start();
        }
    }

}

class MultithreadingDemo1 implements Runnable {
    public void run() {
        try {
            System.out.println("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception is caught");
        }
    }

}
