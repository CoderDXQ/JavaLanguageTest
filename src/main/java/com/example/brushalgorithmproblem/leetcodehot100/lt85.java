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
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        int[][] left = new int[m][n];

//        横向处理 计算宽度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

//        纵向处理 计算高度
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
//                    计算矩形面积
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    //    动态规划
    public static int maximalRectangle2(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] deal = new int[m][n];

//        初始化
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') {
                deal[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    deal[i][j] = deal[i - 1][j] + 1;
                }
            }
        }

//        替换
//        ？？？
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix[i][j] == '1') {
//                    deal[i][j] = (i == 0 ? 0 : deal[i - 1][j]) + 1;
//                }
//            }
//        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                剪枝
                if (deal[i][j] * m <= ans) {
                    continue;
                }
                if (deal[i][j] != 0) {
                    int cnt = 1;
                    for (int k = j + 1; k < n; k++) {
                        if (deal[i][k] < deal[i][j]) {
                            break;
                        }
                        cnt++;
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (deal[i][k] < deal[i][j]) {
                            break;
                        }
                        cnt++;
                    }
                    ans = Math.max(ans, cnt * deal[i][j]);
                }
            }
        }
        return ans;
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

        System.out.println(maximalRectangle2(matrix));
        System.out.println(maximalRectangle2(matrix1));
        System.out.println(maximalRectangle2(matrix2));
        System.out.println(maximalRectangle2(matrix3));
        System.out.println(maximalRectangle2(matrix4));
        System.out.println();

    }

}
