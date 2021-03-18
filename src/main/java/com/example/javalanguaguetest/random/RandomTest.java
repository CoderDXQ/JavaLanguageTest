package com.example.javalanguaguetest.random;

import org.junit.Test;

import java.util.Random;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/18 2:25 下午
 */
public class RandomTest {

    public static void main(String[] args) {

//        0-1之间的随机数
        System.out.println(Math.random());

//        使用随机数生成器
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
//            生成0-2之间的随机正整数
            System.out.println(random.nextInt(3));
        }

    }
}
