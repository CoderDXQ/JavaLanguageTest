package com.example.atest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/3 4:53 下午
 */
public class testGC {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        while (true) {
            list.add(Integer.MAX_VALUE);
            System.out.println(list.size());
            Thread.sleep(100);
        }

    }

}
