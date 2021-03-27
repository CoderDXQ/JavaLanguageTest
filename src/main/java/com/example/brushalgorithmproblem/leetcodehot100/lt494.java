package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:37 下午
 */

//目标和
public class lt494 {

    public static int result = 0;

    //    nums的和与s的差 这个差的一半就是用"-"修饰的数的和  这样问题就转化为了在数组中搜索的情况
    public static int findTargetSumWays(int[] nums, int S) {

        if (nums[0] == S && nums.length == 1) {
            return 1;
        }

        int he = 0;

        for (int i = 0; i < nums.length; i++) {
            he += nums[i];
        }

        he = (he - S) >> 1;

        int num = 0;
        for (int i = 0; i < nums[i]; i++) {
            if (nums[i] == 0) {
                num++;
            }
        }

        int tiao0 = (int) Math.pow(2, num);

        result = 0;
        find(nums, he);

        return result * tiao0;
    }

    public static void find(int[] nums, int he) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (he == nums[i]) {
                    result++;
                } else if (he > nums[i]) {
                    find(nums, he - nums[i]);
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        int s = 1;
        System.out.println(findTargetSumWays(nums, s));
    }
}
