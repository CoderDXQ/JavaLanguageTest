package com.example.writtenexaminationandinterview.rate_limit;

import org.junit.Test;

import java.io.BufferedReader;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用令牌桶算法进行限流
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 11:32 下午
 */
public class TokenBucket {

    public class Bucket {
        //        容量
        int capacity;
        //        速率 每秒往桶里放多少个
        int rateCount;

        //        使用原子类
        AtomicInteger curCount = new AtomicInteger(0);

        public Bucket(int capacity, int rateCount) {
            this.capacity = capacity;
            this.rateCount = rateCount;
        }

        public void put() {
            if (curCount.get() < capacity) {
                System.out.println("目前数量==" + curCount.get() + ",继续放置令牌");
                curCount.addAndGet(rateCount);
            }
        }

        public boolean get() {
            if (curCount.get() >= 1) {
                curCount.decrementAndGet();
                return true;
            }
            return false;
        }
    }

    @Test
    public void testTokenBucket() throws InterruptedException {

//        每次放两个 容量为5
        Bucket bucket = new Bucket(5, 2);

//        周期性执行任务的线程池 核心线程数是1
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            bucket.put();
        }, 0, 1, TimeUnit.SECONDS);

//        让桶里先放点令牌
        Thread.sleep(6000);

//        模拟10个线程取令牌
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                if (bucket.get()) {
                    System.out.println(Thread.currentThread().getName() + "获取了资源");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 被拒绝");
                }
            }).start();
        }

        Thread.sleep(3000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                if (bucket.get()) {
                    System.out.println(Thread.currentThread().getName() + "获取了资源");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 被拒绝");
                }
            }).start();
        }


    }


}
