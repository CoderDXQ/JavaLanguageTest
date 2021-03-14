package com.example.datastructure.sort;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/14 5:48 下午
 */

//时间复杂度O(nlogn) 归并排序有两个主要步骤：分 合
public class MergeSort {
    //    必须要设置数组长度 否则会报索引超界  原因是jvm创建数组如果没有设置长度就只创建一个指针而没有元素
//    避免频繁创建清理带来的性能消耗
    private static int[] arr = new int[10000];

    //    每次只对区间[left,right]进行操作
    public static void Merge(int left, int mid, int right, int[] array) {
//        合
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                arr[k++] = array[i++];
            } else {
                arr[k++] = array[j++];
            }
        }

//        考虑剩下的元素
        while (i <= mid) {
            arr[k++] = array[i++];
        }
        while (j <= right) {
            arr[k++] = array[j++];
        }

//        复制回原数组
        System.arraycopy(arr, left, array, left, right - left + 1);
    }

    public static void MergeSort(int left, int right, int[] array) {
//        分 相等时说明只有一个元素 不能再分了
        if (left < right) {
            int mid = (left + right) >> 1;
//            分
            MergeSort(left, mid, array);
            MergeSort(mid + 1, right, array);
//            合
            Merge(left, mid, right, array);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 4, 3, 5, 7, 8, 2, 3};

        MergeSort(0, array.length - 1, array);

        Arrays.stream(array).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

    }
}
