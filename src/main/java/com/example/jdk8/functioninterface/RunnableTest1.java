package com.example.jdk8.functioninterface;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/9 12:18 上午
 */
public class RunnableTest1 {

    public static void main(String[] args) {

//        没有入参和出参
        Runnable run1 = () -> {
            System.out.println("haha");
        };

        run1.run();
    }
}
