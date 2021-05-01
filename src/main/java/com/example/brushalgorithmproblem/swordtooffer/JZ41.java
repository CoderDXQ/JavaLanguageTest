package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 1:41 上午
 */
//和为S的连续正数序列
public class JZ41 {

    //    前缀和
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        最少是两个数的和 一个数不行 i代表正数序列的起点 j代表正数序列的终点
        for (int i = 1; i <= sum / 2; i++) {
            int k = i;
            for (int j = i + 1; j < sum; j++) {
                k += j;
                if (k == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int n = i; n <= j; n++) {
                        list.add(n);
                    }
                    result.add(list);
                } else if (k > sum) {
//                    剪枝
                    break;
                }
            }
        }
        return result;
    }

    //    滑动窗口 滑动窗口一般都是从左到右移动 窗口大小会发生变化
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1, right = 2, s = left + right;
        while (left <= sum / 2) {
            if (s > sum) {
                s -= left;
                left++;
            } else if (s < sum) {
                right++;
                s += right;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                result.add(list);
//                继续移动
                s -= left;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int sum = 9;
        FindContinuousSequence1(sum).forEach(a -> {
            a.forEach(aa -> {
                System.out.print(aa + " ");
            });
            System.out.println();
        });

        System.out.println();

        FindContinuousSequence2(sum).forEach(a -> {
            a.forEach(aa -> {
                System.out.print(aa + " ");
            });
            System.out.println();
        });
    }
}
