package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:28 下午
 */

//岛屿数量
public class lt200 {

    public static int result;

    //    DFS
    public static int numIslands(char[][] grid) {
//        初始化
        result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    public static void dfs(int i, int j, char[][] grid) {
        if (grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
            if (check(i + 1, j, grid)) {
                dfs(i + 1, j, grid);
            }
            if (check(i, j + 1, grid)) {
                dfs(i, j + 1, grid);
            }
            if (check(i - 1, j, grid)) {
                dfs(i - 1, j, grid);
            }
            if (check(i, j - 1, grid)) {
                dfs(i, j - 1, grid);
            }
        }
    }

    public static boolean check(int i, int j, char[][] grid) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
            return true;
        }
        return false;
    }

    //    BFS
    public static int numIslands1(char[][] grid) {

        int lie = grid[0].length;

        result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * lie + j);
                    while (!queue.isEmpty()) {
                        Integer num = queue.poll();
                        int hang = num / lie;
                        int liee = num % lie;
                        grid[hang][liee] = '0';
                        if (hang + 1 < grid.length && grid[hang + 1][liee] == '1') {
//                            必须要先标记后放入
                            grid[hang + 1][liee] = '0';
                            queue.add((hang + 1) * lie + liee);
                        }
                        if (hang - 1 >= 0 && grid[hang - 1][liee] == '1') {
                            grid[hang - 1][liee] = '0';
                            queue.add((hang - 1) * lie + liee);
                        }
                        if (liee + 1 < grid[0].length && grid[hang][liee + 1] == '1') {
                            grid[hang][liee + 1] = '0';
                            queue.add(hang * lie + liee + 1);
                        }
                        if (liee - 1 >= 0 && grid[hang][liee - 1] == '1') {
                            grid[hang][liee - 1] = '0';
                            queue.add(hang * lie + liee - 1);
                        }
                    }
                }
            }
        }
        return result;
    }

    //    并查集  连通块问题就用并查集
    public static int numIslands2(char[][] grid) {


        return 0;
    }

    public static void main(String[] args) {
        String[][] temp = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

//        被迫进行转换
        char[][] grid = new char[temp.length][temp[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                grid[i][j] = temp[i][j].toCharArray()[0];
            }
        }

//        System.out.println(numIslands(grid));
        System.out.println(numIslands1(grid));
//        System.out.println(numIslands2(grid));

    }
}
