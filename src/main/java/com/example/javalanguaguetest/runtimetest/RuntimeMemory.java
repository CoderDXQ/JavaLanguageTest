package com.example.javalanguaguetest.runtimetest;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/21 12:27 上午
 */
public class RuntimeMemory {//获取内存容量的方法

    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        System.out.println("Total Memory: " + r.totalMemory()/1024);
        System.out.println("Free Memory: " + r.freeMemory()/1024);

        for (int i = 0; i < 1000000; i++) {
            new RuntimeMemory();
        }
        System.out.println("After creating 10000 instance,Free Memory: " + r.freeMemory()/1024);
        System.gc();
        System.out.println("After gc(),Free Memory: " + r.freeMemory()/1024);
    }

}
