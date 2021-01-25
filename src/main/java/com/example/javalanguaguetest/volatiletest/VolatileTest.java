package com.example.javalanguaguetest.volatiletest;

import lombok.SneakyThrows;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/23 10:56 下午
 */
public class VolatileTest {
    private volatile static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {


        @SneakyThrows
        @Override
        public void run() {
            while (!ready) {

//                进来的时候ready是false，500毫秒之后main()方法已经把ready改为true
                System.out.println("ready is : " + ready + " " + Thread.currentThread().getName());
                Thread.sleep(500);

//                if (!ready) {
//                    System.out.println("ready is : " + ready + " " + Thread.currentThread().getName() + " yield");
//                }
                System.out.println("ready is : " + ready + " " + Thread.currentThread().getName() + " yield");

                //线程让步  该线程从执行状态变为就绪状态，后面的代码也不会执行
                Thread.yield();
            }
            System.out.println();
            System.out.println("ready is : " + ready + " " + Thread.currentThread().getName() + "...");
            number++;
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        number = 42;

        for (int i = 0; i < 20; i++) {
            new ReaderThread().start();
        }

//        new ReaderThread().start();

        ready = false;
        Thread.sleep(100);
//        Thread.sleep(1000);
        ready = true;

    }
}
