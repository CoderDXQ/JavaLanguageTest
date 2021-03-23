package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/22 10:13 下午
 */
//组合总和
public class lt39 {

    public static List<List<Integer>> result;

    //    DFS 回溯 剪枝
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ans = new ArrayList<>();
        dfs(candidates, target, 0, ans, 0);
        return result;
    }

    public static void dfs(int[] candidates, int target, int sum, List<Integer> ans, int n) {

        if (sum == target) {
//            添加方式 不新建一个对象的话添加的是地址  在回溯后数据会逐步清除
            result.add(new ArrayList<>(ans));
        }

        for (int i = n; i < candidates.length; i++) {
            //            剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            ans.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], ans, i);
//            回溯
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });

    }
}
