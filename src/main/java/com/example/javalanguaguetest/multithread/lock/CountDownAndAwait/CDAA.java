package com.example.javalanguaguetest.multithread.lock.CountDownAndAwait;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/2 7:19 下午
 */
public class CDAA {
    public static class Worker implements Runnable {
        private CountDownLatch downLatch;
        private String name;

        public Worker(CountDownLatch downLatch, String name) {
            this.downLatch = downLatch;
            this.name = name;
        }

        @Override
        public void run() {
            this.doWork();
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + "活干完了");
            this.downLatch.countDown();
        }

        private void doWork() {
            System.out.println(this.name + "正在干活");
        }
    }

    public static class Boss implements Runnable {
        private CountDownLatch downLatch;
        private String name;

        public Boss(CountDownLatch downLatch, String name) {
            this.downLatch = downLatch;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name + "老板正在等所有工人把活干完");
            try {
                this.downLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("活都干完了，老板开始检查了！");
        }
    }


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                0,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3)
        );

        CountDownLatch latch = new CountDownLatch(3);
        executor.execute(new Worker(latch, "a"));
        executor.execute(new Worker(latch, "b"));
        executor.execute(new Worker(latch, "c"));
        executor.execute(new Worker(latch, "d"));

//        这里四个工人干三份活，所以总有一个工人白干了
        executor.execute(new Boss(latch, "boss"));

        executor.shutdown();
    }

}
