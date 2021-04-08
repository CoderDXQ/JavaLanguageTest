package com.example.writtenexaminationandinterview.rate_limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 使用Guava限流
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 11:31 下午
 */

public class GuavaRateLimiteTest {


    //    每秒生产多少令牌
    private RateLimiter rateLimiter = RateLimiter.create(10);

    public void exeBiz() {
        if (rateLimiter.tryAcquire(1)) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程" + Thread.currentThread().getName() + " 执行业务逻辑");

        } else {
            System.out.println("线程" + Thread.currentThread().getName() + " 被限流");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        GuavaRateLimiteTest limiteTest = new GuavaRateLimiteTest();

//        在这段时间内它会自动产生令牌
        Thread.sleep(500);

        for (int i = 0; i < 100; i++) {
            new Thread(limiteTest::exeBiz).start();
        }

    }


}
