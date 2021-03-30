package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:14 上午
 */
public class lt56 {

    public static int[][] merge(int[][] intervals) {


        return intervals;
    }


    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] a : merge(intervals)) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }

}
