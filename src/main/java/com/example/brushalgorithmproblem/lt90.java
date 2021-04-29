package com.example.brushalgorithmproblem;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/29 11:33 下午
 */
//子集II
public class lt90 {

    public static Set<List<Integer>> ans;

    //   回溯枚举+去重
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

//        初始化
//        result = new ArrayList<>();
//        result.add(new ArrayList<>());
        ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, 0, cur);

        return new ArrayList<>(ans);
    }

    private static void dfs(int[] nums, int u, List<Integer> cur) {
        if (nums.length == u) {
            ans.add(new ArrayList<>(cur));
            return;
        }

//        不选择当前元素  不能这样做 因为递归返回的时候cur里面有下面添加的元素的
//        dfs(nums, u + 1, cur);

//        选择当前元素
        cur.add(nums[u]);
        dfs(nums, u + 1, cur);

//        不选择当前元素 回溯
        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur);

    }


    //    状态压缩+去重 每个元素都有被选择和没被选择两种情况 所以就有2的n次方种情况 n为nums数组的长度
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> anss = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            curr.clear();
            for (int j = 0; j < n; j++) {
                int t = (i >> j) & 1;
                if (t == 1) {
                    curr.add(nums[j]);
                }
            }
            anss.add(new ArrayList<>(curr));
        }

        return new ArrayList<>(anss);

    }


    //    迭代枚举 不使用set去重
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {

        List<Integer> t = new ArrayList<>();
        List<List<Integer>> anss = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int n = nums.length;

//        所有可能性
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
//                这个位运算的结果可能是 1 2 4 8 ......
                if ((mask & (1 << i)) != 0) {
//                检测重复      前一位没选                    与前一位相同
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                anss.add(new ArrayList<Integer>(t));
            }

        }

        return anss;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 2};

        subsetsWithDup(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println("----------------------------------------");

        subsetsWithDup1(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println("----------------------------------------");

        subsetsWithDup2(nums).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println("----------------------------------------");


    }

}
