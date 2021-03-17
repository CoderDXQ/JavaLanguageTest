package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 1:07 上午
 */

//移动零
public class lt283 {

    //    直接覆盖
    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        moveZeroes(nums);

        Arrays.stream(nums).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

    }
}
