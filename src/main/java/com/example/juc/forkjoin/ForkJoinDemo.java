package com.example.juc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:51 上午
 */
//page45 page46
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //    临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) >> 1;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();

            return task1.join() + task2.join();
        }
    }
}
