package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/31 8:10 下午
 */
public class lt79 {

    public static boolean[][] flag;

//    回溯
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = new boolean[board.length][board[0].length];
                    flag[i][j] = true;
                    boolean f = find(board, word, 0, i, j, flag);
                    if (f == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static boolean find(char[][] tu, String word, int index, int i, int j, boolean[][] flag) {
        if ((tu[i][j] == word.charAt(index)) && (index == word.length() - 1)) {
            return true;
        }

//        剪枝 提速
        if (tu[i][j] != word.charAt(index)) {
            return false;
        }

        if (check(i + 1, j, tu) && tu[i + 1][j] == word.charAt(index + 1) && flag[i + 1][j] == false) {
            flag[i + 1][j] = true;
            if (find(tu, word, index + 1, i + 1, j, flag) == true) {
                return true;
            }
            flag[i + 1][j] = false;
        }
        if (check(i, j + 1, tu) && tu[i][j + 1] == word.charAt(index + 1) && flag[i][j + 1] == false) {
            flag[i][j + 1] = true;
            if (find(tu, word, index + 1, i, j + 1, flag) == true) {
                return true;
            }
            flag[i][j + 1] = false;
        }

        if (check(i - 1, j, tu) && tu[i - 1][j] == word.charAt(index + 1) && flag[i - 1][j] == false) {
            flag[i - 1][j] = true;
            if (find(tu, word, index + 1, i - 1, j, flag)) {
                return true;
            }
            flag[i - 1][j] = false;
        }

        if (check(i, j - 1, tu) && tu[i][j - 1] == word.charAt(index + 1) && flag[i][j - 1] == false) {
            flag[i][j - 1] = true;
            if (find(tu, word, index + 1, i, j - 1, flag)) {
                return true;
            }
            flag[i][j - 1] = false;
        }
        return false;
    }


    public static boolean check(int i, int j, char[][] tu) {
        if (i >= 0 && j >= 0 && i < tu.length && j < tu[0].length) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] tu = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(tu, "zz"));

    }


}
