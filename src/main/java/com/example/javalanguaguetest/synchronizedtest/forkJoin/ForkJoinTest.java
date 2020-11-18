package com.example.javalanguaguetest.synchronizedtest.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/18 9:40 下午
 */
//统计随机生成的0-1的随机数中有多少大于0.5的数 本质上是一个蒙特卡洛
public class ForkJoinTest {
    public static void main(String[] args) {

        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        int jishu = 0;
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
            if (numbers[i] > 0.5) jishu++;
        }

        //第四个参数是filter的参数(规则) 过滤器 意思是返回大于x是否大于0.5 这个程序实际上是一个蒙特卡罗方法
        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);

        //生成一个fork-join框架的实例 fork的意思是分叉 join的意思是合并
        ForkJoinPool pool = new ForkJoinPool();
        //调用某个计算任务
        pool.invoke(counter);

        System.out.println("生成随机数时的计数结果：" + jishu);
        //join()方法合并计算结果
        System.out.println("多线程的计数结果：" + counter.join());
    }
}

//RecursiveTask<Integer>表示计算的返回值为Integer 会自动执行compute()方法
class Counter extends RecursiveTask<Integer> {
    //门槛 实际上是整体划分的粒度 当数组的长度小于1000不会再fork，也就是不会再调用空闲线程
    private static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    public Counter(double[] values, int from, int to, DoublePredicate filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    protected Integer compute() {
        //不在分配空闲线程 开始进行计数工作
        if (to - from < THRESHOLD) {
            int count = 0;
            for (int i = from; i < to; i++) {
                //过滤规则是x -> x > 0.5
                if (filter.test(values[i])) count++;
            }

            //查看是哪个线程在工作
            //System.out.println(Thread.currentThread().getName());
            return count;
        } else {
            //fork操作
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            //调用两个空闲线程
            invokeAll(first, second);
            //join 实际上是一个递归的过程
            //因为上面进行了fork 所以这里要返回求和
            return first.join() + second.join();
        }
    }
}
