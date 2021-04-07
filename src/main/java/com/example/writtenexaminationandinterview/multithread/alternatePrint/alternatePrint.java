package com.example.writtenexaminationandinterview.multithread.alternatePrint;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 10:01 下午
 */

//多线程交替打印 使用LockSupport
public class alternatePrint {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aC.length; i++) {
                    System.out.println(aC[i]);
//                    唤醒t2
                    LockSupport.unpark(t2);
//                    阻塞自己 等待唤醒
                    LockSupport.park();
                }

            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aI.length; i++) {
//                    自己阻塞 等待被唤醒 让线程t1先执行
                    LockSupport.park();
                    System.out.println(aI[i]);
//                    唤醒t1
                    LockSupport.unpark(t1);
                }

            }
        });

        t1.start();
        t2.start();

    }

}
