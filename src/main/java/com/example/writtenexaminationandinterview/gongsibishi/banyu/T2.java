package com.example.writtenexaminationandinterview.gongsibishi.banyu;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 8:37 下午
 */
public class T2 {

    public static int[] sort(int[] array) {

        Arrays.sort(array);

        return array;

    }

    public static void main(String[] args) {

        int[] array = new int[]{0, 2, 1, 1};

        for (int i : sort(array)) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
}
