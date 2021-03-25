package com.example.brushalgorithmproblem;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 10:27 下午
 */

//最多能完成排序的块
public class lt769 {

    //    题目的意思是将整个大块的数组分割，但是分割后的小块的相对位置不能改变，小块之间重新排序，这样形成的结果是最大的块的排序的结果
//    抽象建模之后其实就是 在第i位之前的数的最大值不能超过i
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

        int[] arr = new int[]{1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(arr));

    }
}
