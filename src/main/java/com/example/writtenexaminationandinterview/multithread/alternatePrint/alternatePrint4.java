package com.example.writtenexaminationandinterview.multithread.alternatePrint;

import java.io.IOException;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 5:11 下午
 */
public class alternatePrint4 {

    static class SynchronizedWorker implements Runnable {

        private Object lock;
        private String str;

        public SynchronizedWorker(Object lock, String str) {
            this.lock = lock;
            this.str = str;
        }

        @Override
        public void run() {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                synchronized (lock) {
                    System.out.println(c);
//                    唤醒其他线程
                    lock.notify();
                    try {
//                        阻塞
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Object lock = new Object();

        SynchronizedWorker alp = new SynchronizedWorker(lock, "ABCDEFG");
        SynchronizedWorker num = new SynchronizedWorker(lock, "1234567");

        Thread alpThread = new Thread(alp);
        Thread numThread = new Thread(num);

        alpThread.start();
        numThread.start();

//        使用IO阻塞等待
//        System.in.read();

        Thread.sleep(5000);
    }


}
