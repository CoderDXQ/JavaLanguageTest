package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:45 下午
 */
//最大矩形
public class lt85 {

    //    暴力
    public static int maximalRectangle(char[][] matrix) {


        return 0;
    }

    //    单调栈
    public static int maximalRectangle1(char[][] matrix) {


        return 0;
    }

    //    动态规划
    public static int maximalRectangle2(char[][] matrix) {


        return 0;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix1 = new char[][]{};
        char[][] matrix2 = new char[][]{{'0'}};
        char[][] matrix3 = new char[][]{{'1'}};
        char[][] matrix4 = new char[][]{{'0', '0'}};

        System.out.println(maximalRectangle(matrix));
        System.out.println(maximalRectangle(matrix1));
        System.out.println(maximalRectangle(matrix2));
        System.out.println(maximalRectangle(matrix3));
        System.out.println(maximalRectangle(matrix4));
        System.out.println();

        System.out.println(maximalRectangle1(matrix));
        System.out.println(maximalRectangle1(matrix1));
        System.out.println(maximalRectangle1(matrix2));
        System.out.println(maximalRectangle1(matrix3));
        System.out.println(maximalRectangle1(matrix4));
        System.out.println();

        System.out.println(maximalRectangle2(matrix));
        System.out.println(maximalRectangle2(matrix1));
        System.out.println(maximalRectangle2(matrix2));
        System.out.println(maximalRectangle2(matrix3));
        System.out.println(maximalRectangle2(matrix4));
        System.out.println();

    }

}
