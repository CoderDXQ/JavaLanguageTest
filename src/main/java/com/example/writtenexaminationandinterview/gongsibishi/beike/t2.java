package com.example.writtenexaminationandinterview.gongsibishi.beike;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/12 8:01 下午
 */
public class t2 {

    public static List<List<Integer>> list = new ArrayList<>();

//    应该用bfs生成所有策略
    public static void bfs(int m, List<Integer> doo, int index) {

        Queue<List<Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            queue.add(l);
        }

        while (!queue.isEmpty()) {
            List<Integer> l = queue.poll();
            list.add(l);
            for (int i = l.get(l.size() - 1) + 1; i < m; i++) {
                List<Integer> ll = new ArrayList<>(l);
                ll.add(i);
                queue.add(ll);
            }
        }

    }

    public static void dfs(int m, List<Integer> doo, int index) {

        if (!doo.isEmpty()) {
            List<Integer> l = new ArrayList<>(doo);
            list.add(l);
        }

        for (int i = index; i < m; i++) {
            doo.add(i);
            dfs(m, doo, i + 1);
            doo.remove(doo.size() - 1);
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            need[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[][] foods = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                foods[k][j] = in.nextInt();
            }
            k++;
        }

//        生成所有可能
//        dfs(m, new ArrayList<>(), 0);
        bfs(m, new ArrayList<>(), 0);

//        检索所有可能

        for (List<Integer> l : list) {

            int[] have = new int[n];

            for (int kk : l) {
                for (int i = 0; i < n; i++) {
                    have[i] += foods[kk][i];
                }
            }

            boolean find = true;
            for (int i = 0; i < n; i++) {
                if (have[i] < need[i]) {
                    find = false;
                    break;
                }
            }

            if (find == true) {

                System.out.println(l.size());
                for (int i = 0; i < l.size(); i++) {
                    if (i < l.size() - 1) {
                        System.out.print(l.get(i) + 1 + " ");
                    } else {
                        System.out.println(l.get(i) + 1);
                    }
                }
                break;
            }


        }


//        System.out.println();

    }
}
