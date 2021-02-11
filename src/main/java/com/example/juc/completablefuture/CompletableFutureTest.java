package com.example.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/11 3:26 下午
 */

//异步调用
public class CompletableFutureTest {

    //    无返回值
    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " runAsync=>Void");

        });

//        调用执行 有返回值就输出，否则就不输出
        completableFuture.get();
    }

    //    有返回值
    public static void test2() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " supplyAsync=>Integer");
//            制造错误
            int i = 10 / 0;
//            出错之后不执行这个return supplyAsync没有返回值了
            return 1024;
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);//正常的返回结果
            System.out.println("u=>" + u);//错误信息，没有则为null
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            //补全因程序出错而损失的返回值 返回值为233
            return 233;
        }).get());//get方法会输出返回值


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        System.out.println();
        test2();
    }
}
