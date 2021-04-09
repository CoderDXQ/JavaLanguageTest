package com.example.writtenexaminationandinterview.synchronizers;

import java.util.concurrent.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/9 8:56 上午
 */
public class CountDownLatchTest {

    static class Worker implements Callable<Integer> {
        private CountDownLatch latch;
        private int start;
        private int end;

        public Worker(CountDownLatch latch, int start, int end) {
            this.latch = latch;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int count = 0;
            for (int i = start; i <= end; i++) {

                if (isPrime(i)) {
                    count++;
                }
            }
            latch.countDown();
            return count;
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % 1 == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        Cpu数目  cpu密集型
        int cpus = Runtime.getRuntime().availableProcessors() + 1;
        CountDownLatch countDownLatch = new CountDownLatch(cpus);
        ExecutorService executors = Executors.newFixedThreadPool(cpus);

        int bound = 10000000;
        int start = 1, end = 1, step = bound / cpus;
        int count = 0;
        long multiStart = System.currentTimeMillis();

//        用CompletionService包装 方便通过take从blockingQueue中取
        CompletionService<Integer> service = new ExecutorCompletionService<>(executors);

        for (int i = 0; i < cpus; i++) {
            end = Math.min(bound, start + step);
            service.submit(new Worker(countDownLatch, start, end - 1));
            start = end + 1;
        }

//        等待所有线程执行完毕
        countDownLatch.await();

//        合并计算结果
        for (int i = 0; i < cpus; i++) {
            count += service.take().get();
        }
        System.out.println("multi : " + count);
        long multiEnd = System.currentTimeMillis();
        System.out.println("multi : " + (multiEnd - multiStart));
//        关闭线程池
        executors.shutdown();

        int c = 0;
        long singleStart = System.currentTimeMillis();
        for (int i = 1; i <= bound; i++) {
            if (isPrime(i)) {
                c++;
            }
        }
        System.out.println("single : " + c);
        long singleEnd = System.currentTimeMillis();
        System.out.println("single time : " + (singleEnd - singleStart));


    }

}
