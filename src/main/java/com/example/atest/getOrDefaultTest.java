package com.example.atest;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/6/11 10:21 下午
 */
public class getOrDefaultTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
//            这个方法不会以默认值put空值
            System.out.println(map.getOrDefault(i, i));
        }

        System.out.println("输出map的值：");
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

}
