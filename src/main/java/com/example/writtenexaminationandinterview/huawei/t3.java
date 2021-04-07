package com.example.writtenexaminationandinterview.huawei;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 7:01 下午
 */
public class t3 {
    /**
     * 剪枝：差的绝对值=0就退出
     */

    public static int result;

    public static void dfs(int i, int j, int[][] map, int sum, int t) {

//        ???是否有等号？？？
        if (sum > t) {
            return;
        }

        if (i == map.length - 1 && j == map[0].length - 1 && sum <= t) {
            if (result == -1) {
                result = sum;
            } else {
                if (Math.abs(sum - t) < Math.abs(result - t)) {
                    result = sum;
                }
            }
        }

//        只能向两个方向走  所以不需要回溯？？？
        if (i + 1 < map.length) {
            dfs(i + 1, j, map, sum + map[i + 1][j], t);
        }
        if (j + 1 < map[0].length) {
            dfs(i, j + 1, map, sum + map[i][j + 1], t);

        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        result = -1;

//        读入
        int row = in.nextInt();//行
        int col = in.nextInt();//列
        int t = in.nextInt();

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = in.nextInt();
            }
        }

//        注意初始值
        if (row <= 0 || col <= 0 || t <= 0) {
            System.out.println(-1);
        } else {
            dfs(0, 0, map, map[0][0], t);
        }

//        进行计算


        System.out.println(result);
    }
}
