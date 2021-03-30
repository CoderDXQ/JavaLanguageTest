package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:14 上午
 */
public class lt56 {

    //    常规方法
    public static int[][] merge(int[][] intervals) {

//        二维数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (i == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(right, merged.get(merged.size() - 1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        for (int[] a : merge(intervals)) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }

}
