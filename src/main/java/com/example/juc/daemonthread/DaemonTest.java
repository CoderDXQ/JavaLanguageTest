package com.example.juc.daemonthread;

import sun.awt.windows.ThemeReader;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 12:14 上午
 */
public class DaemonTest {

    public static void main(String[] args) {
        new WorkerThread().start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread ending");
    }
}

class WorkerThread extends Thread {
    public WorkerThread() {
//        此时是守护线程  主线程结束后被杀掉
        setDaemon(true);

//        此时是用户线程 主线程结束后继续运行
//        setDaemon(false);
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Hello from Worker" + count++);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
