package com.example.javalanguaguetest.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/28 10:56 上午
 */
public class CreatThreadMethods_Callable implements Callable<Integer> {

    public static void main(String[] args) {
        CreatThreadMethods_Callable ctt = new CreatThreadMethods_Callable();
        FutureTask<Integer> ft = new FutureTask<>(ctt);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值 " + i);
            if (i == 20) {//此时启动一个新的变量
                new Thread(ft, "有返回值的线程" + i).start();
            }
        }

        try {
            //获取ft的返回值，ft会自动执行call()方法
            System.out.println("子线程的返回值： " + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;//返回200
    }
}
