package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/16 10:42 上午
 */

//多数元素
public class lt169 {

    //    摩尔投票法 原理相当于多数元素和非多数元素两两相互抵消
    public static int majorityElement(int[] nums) {
        int num = 1, k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == 0) {
                k = nums[i];
                num++;
                continue;
            }
            num += k == nums[i] ? 1 : -1;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
//        2
        System.out.println(majorityElement(nums));
    }
}
