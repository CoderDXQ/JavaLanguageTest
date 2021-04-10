package com.example.writtenexaminationandinterview.jd;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 7:39 下午
 */
public class jd1 {

    public static void jisun(int[][] kb, int n) {

        int[] result = new int[n - 1];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int num = 0;
                if (kb[i][0] != kb[j][0]) {
                    double x = (double) (kb[j][1] - kb[i][1]) / (kb[i][0] - kb[j][0]);
                    int xx = (int) x;
                    if (xx == x) {
                        int y = (int) (kb[i][0] * x + kb[i][1]);
                        num++;
                        for (int k = j + 1; k < n; k++) {
                            if (y == (kb[k][0] * x + kb[k][1])) {
                                num++;
                            }
                        }
                    }
                }
                if (num > 0) {
                    result[num - 1]++;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] kb = new int[n][2];
        for (int i = 0; i < n; i++) {
            kb[i][0] = in.nextInt();
            kb[i][1] = in.nextInt();
        }
        jisun(kb, n);

    }

}
