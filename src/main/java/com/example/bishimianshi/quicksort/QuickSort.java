package com.example.bishimianshi.quicksort;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/31 8:27 下午
 */
public class QuickSort {

    public static void QuickSort(int[] array, int left, int right) {
        int i = left, j = right;

        while (i <= j) {
            int mid = (left + right) >> 1;
            while (array[i] < array[mid]) {
                i++;
            }
            while (array[j] > array[mid]) {
                j--;
            }
//            这里有等号 否则会陷入死循环
            if (i <= j) {
                swap(array, i, j);
//                非常重要 否则程序就卡在这了
                i++;
                j--;
            }
        }

        if (i < right) {
            QuickSort(array, i, right);
        }

        if (left < j) {
            QuickSort(array, left, j);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 3, 2, 5, 6, 1};

        QuickSort(array, 0, array.length - 1);

        Arrays.stream(array).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();
    }

}
