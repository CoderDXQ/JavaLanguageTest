package com.example.writtenexaminationandinterview.haoweilai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/11 2:16 下午
 */
public class t2 {

    public static int[][] result;
    public static int ji = 0;

    public static int[][] promotions(int n, int k) {
        // write code here

        int s1 = 1;
        int s2 = 1;
        for (int i = 1; i <= k; i++) {
            s2 *= i;
            s1 *= (n - i + 1);
        }

        s1 /= s2;

        result = new int[s1][k];

        dfs(n, k, new ArrayList<Integer>(), 1);


        return result;
    }

    public static void dfs(int n, int k, List<Integer> nums, int index) {

        if (nums.size() == k) {

            for (int i = 0; i < nums.size(); i++) {
                result[ji][i] = nums.get(i);
            }

            ji++;
        }

        for (int j = index; j <= n; j++) {
            nums.add(j);
            dfs(n, k, nums, j + 1);
//            回溯
            nums.remove(nums.size()-1);
        }

    }


    public static void main(String[] args) {
        int n = 4, m = 2;
        promotions(n, m);
    }


}
