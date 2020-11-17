package com.example.javalanguaguetest.collections.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 12:36 下午
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 49; i++)
            numbers.add(i);
        System.out.println(numbers);
        //打乱顺序
        Collections.shuffle(numbers);
        System.out.println(numbers);

        //从动态数组中截取0-6个元素
        List<Integer> winningCombination = numbers.subList(0, 6);
        //排序
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
