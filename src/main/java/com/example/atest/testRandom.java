package com.example.atest;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/27 9:56 上午
 */
public class testRandom {

    public static void main(String[] args) {
        Random random = new Random();

//        生成1以内的小数
        for (int i = 0; i < 5; i++) {
//            System.out.println(random.nextDouble());
            System.out.println(random.nextInt(2));
        }
    }

}
