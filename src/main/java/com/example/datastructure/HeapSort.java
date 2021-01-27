package com.example.datastructure;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 1:32 下午
 */
public class HeapSort {

    //    建堆？？？
    private static void heapsort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i > -1; i--) {
            heapAdjust(arr, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapAdjust(arr, 0, i);
        }
    }

    //    交换
    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    //    堆调整
    private static void heapAdjust(int[] arr, int s, int length) {
        int temp = arr[s];
        for (int j = 2 * s + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (temp > arr[j]) {
                break;
            }
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[8];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            if (in.hasNext()) {
                arr[i] = (int) in.nextInt();
            }
        }

        System.out.println(arr);

        heapsort(arr);


    }
}
