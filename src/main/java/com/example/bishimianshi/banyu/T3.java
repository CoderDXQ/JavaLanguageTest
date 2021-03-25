package com.example.bishimianshi.banyu;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 8:41 下午
 */
public class T3 {

    public static int maxChunksToSorted(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        // 一种简单算法 只是按照一定的规则进行了分块  这些块能不能再组成排序后的数组不知道
        int num = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                num++;
            }
        }

        return num;

    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 3, 4, 4};
        int[] arr = new int[]{5, 2,6,7,6,5,8,8};
        System.out.println(maxChunksToSorted(arr));
    }
}
