package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 4:03 下午
 */

//旋转图像
public class lt48 {

    //    只要求输出没要求存储  这实际上就是一个输出问题  根本不需要对原来的矩阵进行写操作
    public static void rotate(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {

            for (int i = matrix.length - 1; i >= 0; i--) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    //    实际地转换一下数组
    public static void rotate1(int[][] matrix) {

    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);

    }
}
