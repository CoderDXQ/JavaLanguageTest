package com.example.juc.newcharacterofjdk8.functioninterface;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:18 上午
 */
public class RunnableTest1 {

    public static void main(String[] args) {

        Runnable run1 = () -> {
            System.out.println("haha");
        };

        run1.run();
    }
}
