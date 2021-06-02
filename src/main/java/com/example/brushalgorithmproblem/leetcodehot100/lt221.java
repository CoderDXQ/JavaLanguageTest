package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:41 下午
 */
//最大正方形
public class lt221 {

    //    动态规划
//    用dp(i,j)表示以(i,j) 为右下角
//    状态转移方程: dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
    public static int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSize;
        }
        int rows = matrix.length, columns = matrix[0].length;

        int dp[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
//                    将初始化放到动态规划的过程中
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        int maxSquare = maxSize * maxSize;
        return maxSquare;
    }

    //    二进制 使用位运算计算宽度
    public static int maximalSquare2(char[][] matrix) {

        int n = matrix.length;

        int maxSize = 0;

        for (int i = 0; i < n; i++) {

            char[] num = matrix[i];

            for (int j = i; j < n; j++) {
//                进行与运算
                num = and(num, matrix[j]);
                int width = getWidth(num);
                int height = j - i + 1;
//                height, width取最小值
                maxSize = Math.max(maxSize, Math.min(height, width));
            }

        }

        return maxSize * maxSize;
    }

    private static char[] and(char[] num, char[] matrix) {
        for (int i = 0; i < num.length; i++) {
//            简化思维
            if (matrix[i] == '0') {
                num[i] = '0';
            }
        }
        return num;
    }

    private static int getWidth(char[] bin) {

        int width = 0;
        int persist = 0;

        for (int i = 0; i < bin.length; i++) {
            if (bin[i] == '1') {
                persist++;
            } else {
                width = Math.max(width, persist);
                persist = 0;
            }
        }

//        最后跳出循环时 persist可能大于width 这里需要更新一下
        width = Math.max(width, persist);

        return width;
    }

    //    暴力
    public static int maximalSquare1(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSize;
        }

        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
//                遇到一个新的可能的起点
                if (matrix[i][j] == '1') {
                    maxSize = Math.max(1, maxSize);
//                    计算可能的最大正方形长
                    int currentMaxSize = Math.min(rows - i, columns - j);

                    for (int k = 1; k < currentMaxSize; k++) {

                        boolean falg = true;

//                        特判
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }

                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                falg = false;
                                break;
                            }
                        }

                        if (falg) {
                            maxSize = Math.max(maxSize, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSize * maxSize;
        return maxSquare;
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
