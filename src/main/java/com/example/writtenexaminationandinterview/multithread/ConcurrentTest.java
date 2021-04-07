package com.example.writtenexaminationandinterview.multithread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟并发测试接口
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 5:12 下午
 */
public class ConcurrentTest {

    private static final int MAX_THREADS = 10;

    private CountDownLatch cdl = new CountDownLatch(1);


    @Test
    public void testInterface() {
        for (int i = 0; i < MAX_THREADS; i++) {

            Thread t = new Thread(() -> {
                try {
                    cdl.await();
                    Thread.sleep(100);
                    System.out.println("Method call success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t.start();
        }

//        阻塞 一个线程执行完之后就-1 当为0时在接着执行
        cdl.countDown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
