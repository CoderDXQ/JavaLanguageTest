package com.example.writtenexaminationandinterview.rate_limit;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore进行限流
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/8 11:32 下午
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(10);

    public static void bizMethod() throws InterruptedException {
//        获取一个信号
        if (!semaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + "被拒绝");
            return;
        }

        System.out.println(Thread.currentThread().getName() + "执行业务逻辑");
//        模拟处理业务逻辑耗时
        Thread.sleep(500);
//        释放一个信号
        semaphore.release();
    }


    public static void main(String[] args) {

        Timer timer = new Timer();
//        每1000毫秒释放全部的资源
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("增加10把锁");
                semaphore.release(10);
            }
        }, 1000, 1000);

        for (int i = 0; i < 1000; i++) {

            try {
//                模拟每10ms进来一个请求
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(() -> {

                try {
                    SemaphoreTest.bizMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

        }


    }


}
