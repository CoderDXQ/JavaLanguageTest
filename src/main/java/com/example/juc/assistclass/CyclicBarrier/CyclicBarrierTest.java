package com.example.juc.assistclass.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/7 10:28 下午
 */

//本质上是一个计数线程数的加法器
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功！");
        });

        for (int i = 0; i < 10; i++) {
            final int temp = i;

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集" + (temp + 1) + "个龙珠");

                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
