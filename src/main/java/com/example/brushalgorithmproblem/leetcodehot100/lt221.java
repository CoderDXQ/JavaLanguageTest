package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:41 下午
 */
//最大正方形
public class lt221 {

    //    动态规划
    public static int maximalSquare(char[][] matrix) {

        return 0;
    }

    //    单调栈
    public static int maximalSquare1(char[][] matrix) {

        return 0;
    }

    //    二进制
    public static int maximalSquare2(char[][] matrix) {

        return 0;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {
                '1', '0', '0', '1', '0'}};

        char[][] matrix1 = new char[][]{{'0', '1'}, {'1', '0'}};
        char[][] matrix2 = new char[][]{{'0'}};

        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare1(matrix));
        System.out.println(maximalSquare2(matrix));

        System.out.println();

        System.out.println(maximalSquare(matrix1));
        System.out.println(maximalSquare1(matrix1));
        System.out.println(maximalSquare2(matrix1));

        System.out.println();

        System.out.println(maximalSquare(matrix2));
        System.out.println(maximalSquare1(matrix2));
        System.out.println(maximalSquare2(matrix2));

    }

}
