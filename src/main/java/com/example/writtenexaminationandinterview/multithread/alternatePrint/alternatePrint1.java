package com.example.writtenexaminationandinterview.multithread.alternatePrint;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 11:23 下午
 */
//多线程交替打印 使用synchronized
public class alternatePrint1 {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        Object lock = new Object();

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aC.length; i++) {
                    synchronized (lock) {
                        System.out.println(aC[i]);
//                        释放锁 唤醒其他线程
                        lock.notify();

                        try {
//                            自己阻塞  等待被唤醒
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aI.length; i++) {
                    synchronized (lock) {
                        System.out.println(aI[i]);
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        t1.start();
        t2.start();

    }
}
