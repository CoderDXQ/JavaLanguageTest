package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 11:54 上午
 */

//最长递增子序列
public class lt300 {

    //    动态规划
    public static int lengthOfLIS(int[] nums) {
        int result = 1;
//        记录在某个下标的最长递增子序列的长度
        int[] dp = new int[nums.length];
//        初始化
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
//            初始化
            dp[i] = 1;
//            从头开始比较 保证无后效性
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    //  贪心+二分查找
    public static int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
//                数组d就是最长递增子序列
                d[++len] = nums[i];
            } else {
//                二分查找
                int l = 1, r = len, pos = 0;
                while (l <= r) {
//                    这样pos最后的值就是最接近nums[i]但是小于nums[i]的值
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        l = mid + 1;
                        pos = mid;
                    } else {
                        r = mid - 1;
                    }
                }
//                这个更新没有后效性
//                更新最长递增子序列
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
    }

}
