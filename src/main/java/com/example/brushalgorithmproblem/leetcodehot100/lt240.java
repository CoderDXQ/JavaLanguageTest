package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 4:46 下午
 */
//搜索二维矩阵 II
public class lt240 {

    //    本质上是一个抽象的双指针问题 二维双指针 向两个方向走 且两个方向带来的效果是相反的
    public static boolean searchMatrix(int[][] matrix, int target) {
//        从右上角开始搜索
        int i = 0;
        int j = matrix[0].length - 1;
        while (i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 0;
        System.out.println(searchMatrix(matrix, target));
    }
}
