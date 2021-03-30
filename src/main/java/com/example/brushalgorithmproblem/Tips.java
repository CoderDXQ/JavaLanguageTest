package com.example.brushalgorithmproblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/29 4:40 下午
 */

//做题时常用的一些技巧方法
//junit里的test方法不能是静态的
public class Tips {

    /**
     * 基本类型数组转包装类型数组
     */
    @Test
    public void test() {
        int[] jilu = new int[]{};
        Integer[] jisuan = IntStream.of(jilu).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
    }


    /**
     * 二维数组排序
     */
    @Test
    public void test1() {
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer i1 = o1[0];
                Integer i2 = o2[0];
                return i1.compareTo(i2);
            }
        });

        for (int[] a : intervals) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }


    /**
     * 定义优先队列
     */
    @Test
    public void test2() {

//        定义大根堆
        int k = 5;
        int[] nums = new int[]{2, 4, 7, 1, 4, 9};
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int n : nums) {
            queue.offer(n);
        }
        System.out.println(queue.peek());

        System.out.println();

//        定义小根堆
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int n : nums) {
            queue1.offer(n);
        }
        System.out.println(queue1.peek());

    }






}
