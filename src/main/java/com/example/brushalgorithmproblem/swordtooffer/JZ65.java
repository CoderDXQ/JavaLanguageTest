package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 11:38 下午
 */
//矩阵中的路径
public class JZ65 {

    //    可以将二维坐标计算成一位下的坐标或者直接使用一维来计算(后面的太麻烦直接放弃)
    public static boolean hasPath(String matrix, int rows, int cols, String str) {
        boolean[] visited = new boolean[matrix.length()];

        for (int i = 0; i < matrix.length(); i++) {
            if (matrix.charAt(i) == str.charAt(0)) {
//                java给数组批量赋值的方法
                Arrays.fill(visited, false);
                int hang = i / cols;
                int lie = i % cols;
                int k = 0;
                if (check(matrix, rows, cols, str, hang, lie, visited, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(String matrix, int rows, int cols, String str, int hang, int lie, boolean[] visited, int k) {
        if (k == str.length() - 1) {
            return true;
        }
        visited[hang * cols + lie] = true;
        if ((hang + 1) * cols + lie >= 0 && (hang + 1) * cols + lie < matrix.length() && matrix.charAt((hang + 1) * cols + lie) == str.charAt(k + 1) && hang + 1 >= 0 && hang + 1 < rows && lie >= 0 && lie < cols && visited[(hang + 1) * cols + lie] == false) {
            if (check(matrix, rows, cols, str, hang + 1, lie, visited, k + 1)) {
                return true;
            } else {
//                回溯
                visited[(hang + 1) * cols + lie] = false;
            }
        }
        if ((hang - 1) * cols + lie >= 0 && (hang - 1) * cols + lie < matrix.length() && matrix.charAt((hang - 1) * cols + lie) == str.charAt(k + 1) && hang - 1 >= 0 && hang - 1 < rows && lie >= 0 && lie < cols && visited[(hang - 1) * cols + lie] == false) {
            if (check(matrix, rows, cols, str, hang - 1, lie, visited, k + 1)) {
                return true;
            } else {
                visited[(hang - 1) * cols + lie] = false;
            }
        }
        if (hang * cols + lie + 1 >= 0 && hang * cols + lie + 1 < matrix.length() && matrix.charAt(hang * cols + lie + 1) == str.charAt(k + 1) && hang >= 0 && hang < rows && lie + 1 >= 0 && lie + 1 < cols && visited[hang * cols + lie + 1] == false) {
            if (check(matrix, rows, cols, str, hang, lie + 1, visited, k + 1)) {
                return true;
            } else {
                visited[hang * cols + lie + 1] = false;
            }
        }
        if (hang * cols + lie - 1 >= 0 && hang * cols + lie - 1 < matrix.length() && matrix.charAt(hang * cols + lie - 1) == str.charAt(k + 1) && hang >= 0 && hang < rows && lie - 1 >= 0 && lie - 1 < cols && visited[hang * cols + lie - 1] == false) {
            if (check(matrix, rows, cols, str, hang, lie - 1, visited, k + 1)) {
                return true;
            } else {
                visited[hang * cols + lie - 1] = false;
            }
        }
        return false;
    }


    //简化思维
    public static boolean hasPath1(String matrix, int rows, int cols, String str) {
        boolean[] visited = new boolean[matrix.length()];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int location = i * cols + j;
                if (matrix.charAt(location) == str.charAt(0)) {
//                    数组整体赋初值
                    Arrays.fill(visited, false);
                    if (check1(matrix, rows, cols, str, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean check1(String matrix, int rows, int cols, String str, int i, int j, int k, boolean[] visited) {

//        递归地退出和判断条件一般写在递归函数的前面

        int location = i * cols + j;

//        检查是否合规
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[location] == true || matrix.charAt(location) != str.charAt(k)) {
            return false;
        }

        if (k == str.length() - 1) {
            return true;
        }
//        标记
        visited[location] = true;
//        向四个方向进行探索
        if (check1(matrix, rows, cols, str, i + 1, j, k + 1, visited) ||
                check1(matrix, rows, cols, str, i - 1, j, k + 1, visited) ||
                check1(matrix, rows, cols, str, i, j + 1, k + 1, visited) ||
                check1(matrix, rows, cols, str, i, j - 1, k + 1, visited)) {
            return true;
        }
//        回溯
        visited[location] = false;

        return false;
    }

    public static void main(String[] args) {

        String matrix = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String str = "ABCCED";

//        true
        System.out.println(hasPath("ABCESFCSADEE", rows, cols, "ABCCED"));
//        false
        System.out.println(hasPath("ABCESFCSADEE", rows, cols, "ABCB"));

//        true
        System.out.println(hasPath("ABCESFCSADEE", rows, cols, "SEE"));

        //        true
        System.out.println(hasPath1("ABCESFCSADEE", rows, cols, "ABCCED"));
//        false
        System.out.println(hasPath1("ABCESFCSADEE", rows, cols, "ABCB"));

//        true
        System.out.println(hasPath1("ABCESFCSADEE", rows, cols, "SEE"));

    }
}
