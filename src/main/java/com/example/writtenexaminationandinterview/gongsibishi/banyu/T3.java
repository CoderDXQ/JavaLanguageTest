package com.example.writtenexaminationandinterview.gongsibishi.banyu;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 8:41 下午
 */
//leetcode769
public class T3 {

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
//            从最前面开始的这个块的最大值等于当前下标  说明又能分出一个块来
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 3, 4, 4};
        int[] arr = new int[]{5, 2,6,7,6,5,8,8};
        System.out.println(maxChunksToSorted(arr));
    }
}
