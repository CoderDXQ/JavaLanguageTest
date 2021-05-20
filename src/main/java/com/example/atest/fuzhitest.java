package com.example.atest;

import java.util.Arrays;

/**
 * @author duanxiangqing
 * @date 2021/5/20
 */
public class fuzhitest {


    public static void main(String[] args) {

        int n = 3, m = 4;

        int[][] mem = new int[n + 1][m + 1];

//        使用Arrays.fill()进行初始化  这个方法只能对一维数组进行操作
        for (int i = 0; i <= n; i++) {
            Arrays.fill(mem[i], -1);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(mem[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                mem[i][j] = 0;
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(mem[i][j] + " ");
            }
            System.out.println();
        }


    }

}
