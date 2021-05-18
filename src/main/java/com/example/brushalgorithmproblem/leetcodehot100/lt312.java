package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author duanxiangqing
 * @date 2021/5/17
 */
//戳气球
public class lt312 {

    //    DFS优化 记忆化搜索 逆向思维 分治思想,自顶向下再递归回来
    public static int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

//        初始化
        int n = nums.length;

        int[] arr = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n + 1] = 1;


        int[][] cache = new int[n + 2][n + 2];

//        Arrays.fill()方法只能给一维数组赋值
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(cache[i], -1);
        }

        return remdfs(cache, arr, 0, n + 1);

    }

    public static int remdfs(int[][] cache, int[] arr, int left, int right) {

        if (left >= right - 1) {
            return 0;
        }

        if (cache[left][right] != -1) {
            return cache[left][right];
        }

        int res = 0;

//        在left和right这个区间中添加元素
        for (int i = left + 1; i < right; i++) {
//            添加的时候不能打破nums数组中元素的相对顺序
            int point = arr[left] * arr[i] * arr[right];
//            分治思想
            point += remdfs(cache, arr, left, i) + remdfs(cache, arr, i, right);
            res = Math.max(point, res);
        }

        cache[left][right] = res;

        return res;
    }

    //   区间动态规划 区间DP 具体过程可以根据上面的方法理解
//    自底向上
//    区间DP就是用二维数组来计算某个区间的最优结果 二维数组元素的下标就是区间的两个端点
    public static int maxCoins1(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];

        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {//左边界
            for (int j = i + 2; j <= n + 1; j++) {//右边界
                for (int k = i + 1; k < j; k++) {
//                    外层的  后来扎破的气球造成的结果
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(sum, rec[i][j]);
                }
            }
        }

        return rec[0][n + 1];
    }

    //    DFS 删除思维 模拟 时间复杂度是n! 实际上就是全排列问题
    public static int maxCoins2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

//        将数组转化为链表方便删除使用过的元素
        LinkedList<Integer> arr = new LinkedList<>();

        for (int i : nums) {
            arr.add(i);
        }

        return dfs(arr);
    }

    //    回溯
    public static int dfs(LinkedList<Integer> arr) {

        if (arr.size() == 0) {
            return 0;
        }

        int n = arr.size();
        int res = 0;

        for (int i = 0; i < n; i++) {

            int left = (i - 1 >= 0) ? arr.get(i - 1) : 1;
            int right = (i + 1 < n) ? arr.get(i + 1) : 1;

            int point = arr.get(i) * left * right;

            int temp = arr.remove(i);

            point += dfs(arr);

            res = Math.max(res, point);

//            回溯
            arr.add(i, temp);

        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 5, 8};
        int[] nums1 = new int[]{1, 5};

        System.out.println(maxCoins(nums));
        System.out.println(maxCoins(nums1));

        System.out.println();

        System.out.println(maxCoins1(nums));
        System.out.println(maxCoins1(nums1));

        System.out.println();

        System.out.println(maxCoins2(nums));
        System.out.println(maxCoins2(nums1));

    }

}
