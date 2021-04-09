package com.example.writtenexaminationandinterview.synchronizers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore用来控制并发数
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/9 8:57 上午
 */
public class SemaphoreTest {

    static class Request implements Runnable {

        private Semaphore semaphore;
        private int sum;

        public Request(Semaphore semaphore, int sum) {
            this.semaphore = semaphore;
            this.sum = sum;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.out.println(sum + "获得了许可");
                Thread.sleep(new Random().nextInt(3000));
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i <= 20; i++) {
            executorService.submit(new Request(semaphore, i));
        }

        executorService.shutdown();

    }

}
