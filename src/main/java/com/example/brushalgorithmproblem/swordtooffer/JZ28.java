package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/3 10:53 下午
 */
public class JZ28 {

    //    排序直接找中间的数 然后验一下个数是否过半
//    顺便写一下快速排序


    public static int MoreThanHalfNum_Solution(int[] array) {
        int result = QuickSort(array, 0, array.length - 1)[array.length / 2];

        int count = 0;
        for (int i : array) {
            if (result == i) {
                count++;
            }
        }
        if (count > (array.length / 2)) {
            return result;
        }

        return 0;
    }

    public static int[] QuickSort(int[] array, int left, int right) {

        int i = left, j = right, base = (i + j) / 2;

        while (i <= j) {
            while (array[i] < array[base]) {
                i++;
            }
            while (array[j] > array[base]) {
                j--;
            }
//            存在这种情况
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            array = QuickSort(array, left, j);
        }
        if (i < right) {
            array = QuickSort(array, i, right);
        }

        return array;
    }


    //    总体抵消  非常巧妙的一个算法
    public static int MoreThanHalfNum_Solution1(int[] array) {
        int num = -1;
        int count = 0;

//        如果数组中当前的数与num相同，num的数量count就+1，不相同就抵消-1
        for (int i : array) {
            if (count == 0) {
                num = i;
                count++;
            } else {
                if (num == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }

//        检查众数的数量是否过半
        count = 0;
        for (int i : array) {
            if (i == num) {
                count++;
            }
        }

        if (count > array.length / 2) {
            return num;
        }

        return 0;
    }

    //HashMap
    public static int MoreThanHalfNum_Solution2(int[] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i : array) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        int result = 0;
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) > (array.length / 2)) {
                return key;
            }
        }

        return result;
    }


    public static void main(String[] args) {

//        数组里面不一定存在这么一个数
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println(MoreThanHalfNum_Solution(array));
        System.out.println(MoreThanHalfNum_Solution1(array));
        System.out.println(MoreThanHalfNum_Solution2(array));

    }
}
