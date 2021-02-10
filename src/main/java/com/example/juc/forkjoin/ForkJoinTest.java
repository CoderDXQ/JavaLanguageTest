package com.example.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/10 11:54 下午
 */
public class ForkJoinTest {

    //普通方法
    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }


    //    使用ForkJoin 也可以用递归来实现，其实本质就是递归
    public static void test2() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();

//        创建ForkJoin池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        创建计算任务
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
//        提交计算任务
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
//        获取ForkJoin计算结果
        Long sum = submit.get();

        Long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    //    使用Stream并行流
    public static void test3() {
        Long start = System.currentTimeMillis();
//        左开右闭区间 并行计算
        Long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();

    }
}
