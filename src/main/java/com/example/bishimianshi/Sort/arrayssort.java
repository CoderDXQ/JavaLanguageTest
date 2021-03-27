package com.example.bishimianshi.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 10:27 上午
 */
public class arrayssort {

    public static <T> void print(T[] array) {
        for (T o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    //    自定义Arrays.sort()的排序规则   包括整型 浮点型 字符串 字符
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{3, 4, 5, 1, 2, 7};
        String[] sts = new String[]{"fdsf", "a", "ad", "gfd", "qe"};
        Double[] dous = new Double[]{1.3, 1.56, 0.89, 8.0, 67.0};
        Character[] chs = new Character[]{'v', 'a', 'd', 'g', 'r', 'y', 'j', 'p'};

//        升序排序
//        Arrays.sort(nums);
//        Arrays.sort(sts);
//        Arrays.sort(dous);
//        Arrays.sort(chs);

//        降序排列
//        重写比较器
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Arrays.sort(sts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Arrays.sort(dous, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        Arrays.sort(chs, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });

//        先升序排序再翻转 写法比较简单  但是慢一点
//        Arrays.sort(nums, Collections.reverseOrder());
//        Arrays.sort(sts, Collections.reverseOrder());
//        Arrays.sort(dous, Collections.reverseOrder());
//        Arrays.sort(chs, Collections.reverseOrder());

        print(nums);
        print(sts);
        print(dous);
        print(chs);

    }
}
