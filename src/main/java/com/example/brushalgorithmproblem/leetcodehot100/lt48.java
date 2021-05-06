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

    //    借助数组实现旋转 空间复杂度O(n*n)
    public static void rotate3(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }

    }

    //  转化问题的思想 这也是一种原地算法 两次翻转代替旋转  这个旋转图像可以转化为一次水平翻转+一次对角线翻转
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;

//        完成纵向翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

//        完成对角线翻转
        for (int i = 0; i < n; i++) {
//            这个地方要注意限制j的极限 否则会把之前翻转的再翻转一次  相当于没有翻转
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }

    }

    //    另一种两个方向进行翻转代替旋转 翻转的时候选好方向可以使问题更简单
    public static void rotate4(int[][] matrix) {

        int n = matrix.length;
        int temp;
//        完成水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
//        完成对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(matrix);
//        rotate1(matrix);
//        rotate2(matrix);
//        rotate3(matrix);
        rotate4(matrix);
    }
}
