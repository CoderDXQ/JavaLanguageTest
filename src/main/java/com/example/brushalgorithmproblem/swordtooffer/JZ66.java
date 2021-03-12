package com.example.brushalgorithmproblem.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 11:39 下午
 */
public class JZ66 {

    public static int sum = 0;

    public static boolean isvalid(int i, int j, int threshold) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
//        System.out.println(sum);
        if (sum > threshold) {
            return false;
        }
        return true;
    }

    //    可以在dfs或者bfs进行之前标记不能访问的格子 也可以在dfs或者bfs进行的时候进行判断
    public static int movingCount(int threshold, int rows, int cols) {
        int result = 0;
        boolean[][] notvisit = new boolean[rows][cols];
//        Arrays.fill(notvisit, false);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                notvisit[i][j] = false;
            }
        }
        sum = 0;
        result = dfs(rows, cols, notvisit, 0, 0, threshold);
        return result;
    }

    //    把超过threshold的点也标记一下可以简化计算
    public static int dfs(int rows, int cols, boolean[][] notvisit, int i, int j, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || !isvalid(i, j, threshold) || notvisit[i][j] == true) {
            return 0;
        }

        sum++;
        notvisit[i][j] = true;

        dfs(rows, cols, notvisit, i + 1, j, threshold);
        dfs(rows, cols, notvisit, i - 1, j, threshold);
        dfs(rows, cols, notvisit, i, j + 1, threshold);
        dfs(rows, cols, notvisit, i, j - 1, threshold);

        return sum;
    }

    //    bfs
    public static int movingCount1(int threshold, int rows, int cols) {
        int result = 0;
        boolean[][] notvisit = new boolean[rows][cols];
//        Arrays.fill(notvisit, false);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                notvisit[i][j] = false;
            }
        }

        int sum = 0;
        result = bfs(rows, cols, notvisit, threshold);

        return result;
    }

    //    把超过threshold的点也标记一下可以简化计算
    public static int bfs(int rows, int cols, boolean[][] notvisit, int threshold) {
        int sum = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair<Integer>(0, 0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            Integer i = (Integer) node.getFirst();
            Integer j = (Integer) node.getSecond();
//            可以到达
            if (i >= 0 && i < rows && j >= 0 && j < cols && isvalid(i, j, threshold) && notvisit[i][j] == false) {
                sum++;
                notvisit[i][j] = true;
                if (check(rows, cols, i + 1, j, notvisit, threshold)) {
                    queue.offer(new Pair<Integer>(i + 1, j));
                }
                if (check(rows, cols, i - 1, j, notvisit, threshold)) {
                    queue.offer(new Pair<Integer>(i - 1, j));
                }
                if (check(rows, cols, i, j + 1, notvisit, threshold)) {
                    queue.offer(new Pair<Integer>(i, j + 1));
                }
                if (check(rows, cols, i, j - 1, notvisit, threshold)) {
                    queue.offer(new Pair<Integer>(i, j - 1));
                }
            }
        }
        return sum;
    }

    public static boolean check(int rows, int cols, int i, int j, boolean[][] notvisit, int threshold) {
        if (i >= 0 && i < rows && j >= 0 && j < cols && isvalid(i, j, threshold) && notvisit[i][j] == false) {
            return true;
        }
        return false;
    }

    //    自定义Pair
    public static class Pair<T> {
        private T first;
        private T second;

        public Pair() {
            first = null;
            second = null;
        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }


    public static void main(String[] args) {
        int threshold = 5;
        int rows = 10;
        int cols = 10;

//        测试isvalid()
//        System.out.println(isvalid(35, 37, 5));

//        21 dfs
        System.out.println(movingCount(threshold, rows, cols));

//        21 bfs
        System.out.println(movingCount1(threshold, rows, cols));

    }
}
