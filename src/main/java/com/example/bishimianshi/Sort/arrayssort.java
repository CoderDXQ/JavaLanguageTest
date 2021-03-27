package com.example.bishimianshi.Sort;

import java.util.Arrays;

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

        print(nums);
        print(sts);
        print(dous);
        print(chs);

//        降序排序


    }
}
