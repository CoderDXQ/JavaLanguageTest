package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 2:56 下午
 */

//跳跃游戏
public class lt55 {

    //    向下搜索
    public static boolean canJump(int[] nums) {

//        need代表需要跳的距离
        int need = nums.length - 1;
        return dojump(nums, 0, need);

    }

    public static boolean dojump(int[] nums, int pos, int need) {

        if (need <= nums[pos]) {
            return true;
        } else {
            if (nums[pos] == 0) {
                return false;
            }
            for (int i = 1; i <= nums[pos]; i++) {
                if (dojump(nums, pos + i, need - i) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));

    }
}
