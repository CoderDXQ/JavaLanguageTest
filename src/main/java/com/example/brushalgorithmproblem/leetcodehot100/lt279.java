package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 4:09 下午
 */
//完全平方数
public class lt279 {

    public static int reslult;

    //    这种枚举会超时
    public static int numSquares(int n) {

//        产生所有可用的完全平方数
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            nums.add(i * i);
        }

//        初始化
        reslult = Integer.MAX_VALUE;
        dfs(nums, n, 0, 0);

        return reslult;

    }

    public static void dfs(ArrayList<Integer> nums, int n, int sum, int num) {

        if (sum == n) {
            reslult = Math.min(reslult, num);
        }

        if (sum > n) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            dfs(nums, n, sum + nums.get(i), num + 1);
        }

    }

    //    动态规划
    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
//            最大的情况是当前和的组成全部为1
            dp[i] = i;
//            j*j是完全平方数
            for (int j = 1; i - j * j >= 0; j++) {
//                状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    //    建立m叉树+层序遍历 但是这里简化了 不建立具体的树 而是直接进行层序运算  把同一层放在一个队列（这里用Set，带有去重功能，可以防止重复计算）里
    public static int numSquares2(int n) {
//        完全平方数数组
        ArrayList<Integer> squarenums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squarenums.add(i * i);
        }

//        层序遍历
        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> next_queue = new HashSet<Integer>();
            for (int num : queue) {
//                由于生成方式的原因 squarenums中的数字的顺序是递增的
                for (int cut : squarenums) {
                    if (num == cut) {
                        return level;
                    } else if (num < cut) {
                        break;
                    } else {
                        next_queue.add(num - cut);
                    }
                }
            }
//            将新的队列赋值给用于层序循环的队列上
            queue = next_queue;
        }
        return level;
    }


    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));

        System.out.println(numSquares1(n));

        System.out.println(numSquares2(n));
    }
}
