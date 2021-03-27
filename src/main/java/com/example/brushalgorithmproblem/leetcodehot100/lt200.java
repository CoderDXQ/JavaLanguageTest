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

    //    并查集
    static class UnionFind {
        //        连通块数量
        int count;
        //parent数组中存放的是下标的爹
        int[] parent;
        int[] rank;

        //        构造函数
        public UnionFind(char[][] grid) {
//            地块数量
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
//                        并查集初始化  此时每个点的父亲都是自己
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
//            只有所有人的爹才能给自己当爹
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
//            三目运算符写法
//           return parent[i] == i ? parent[i] : find(parent[i]);
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
//            不在同一个连通块里 此时需要合并
            if (rootx != rooty) {
//                大的当爹
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
//                    设置爹的rank值
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    //    并查集  连通块问题就用并查集
    public static int numIslands2(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
//        初始化并查集
        UnionFind uf = new UnionFind(grid);

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
//                    miu掉
                    grid[r][c] = '0';
//                    把某个块周围的地块连接到这个块上
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
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
//        System.out.println(numIslands1(grid));
        System.out.println(numIslands2(grid));

    }
}
