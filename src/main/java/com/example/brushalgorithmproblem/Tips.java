package com.example.brushalgorithmproblem;

import org.junit.Test;

import java.util.*;
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
     * List与数组互相转化
     */
    @Test
    public void test3() {

        String[] sts = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(sts);
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
//        第一  必须确定数组的长度
//        第二 toArray()方法中传入数组变量
//        Integer[] nums = new Integer[l.size()];
//        nums = l.toArray(nums);
        Integer[] nums = l.toArray(new Integer[l.size()]);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

    }


    /**
     * 二维数组排序
     * 自定义paixv
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

    /**
     * 数字转换为字符串的技巧
     * 字符转换为字符串的技巧
     */
    @Test
    public void test04() {
        Integer i = 1;
        char c = '1';

//        false
        System.out.println("1".equals(i));
//        true
        System.out.println("1".equals(i + ""));
        System.out.println();
//        false
        System.out.println("1".equals(c));
//        true
        System.out.println("1".equals(c + ""));


    }

    /**
     * 下一个排列
     * 返回一个数组
     *
     * @param nums
     * @return
     */
    public static int[] nextPermutation(int[] nums) {

        int k = nums.length - 2;
//        寻找最后边的第一个升序对 此时就找到了较小数
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }

//        找到右边的较大数
        if (k > -1) {
//        k的右边是一个降序序列
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[k]) {
                j--;
            }
            swap(nums, k, j);
        }

        reverse(nums, k + 1);

        return nums;
//        for (int i : nums) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

    }

    /**
     * 交换数组中的两个数
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 实现数组某个下标之后部分的翻转
     *
     * @param nums
     * @param i
     */
    public static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * 链表翻转
     *
     * @param list
     */
    public static void reverse(List list) {
        Collections.reverse(list);
    }


}
