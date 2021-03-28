package com.example.bishimianshi.microsoftware;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 2:19 下午
 */
public class t3 {
    public static int solution(int[] A, int M) {
        // write your code in Java SE 8
        UnionFind unionFind = new UnionFind(A.length);
        boolean[] mark = new boolean[A.length];
        for (int i = 0; i < A.length; ++i) {
            if (mark[i]) continue;
            for (int j = 0; j < A.length; ++j) {
                if (i == j) continue;
                if (Math.abs(A[i] - A[j]) % M == 0) {
                    unionFind.union(i, j);// 如果符合条件，就进行合并
                    mark[j] = true;// 标记合并过的point，减少循环次数
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int item : unionFind.parent) {
            int curNum = map.getOrDefault(item, 0);
            map.put(item, curNum + 1);
            res = Math.max(res, curNum + 1);
        }
        return res;
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            this.rank = new int[n];
        }

        int find(int idx) {
            while (parent[idx] != idx) idx = parent[idx];
            return idx;
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{7, 1, 11, 8, 4, 10};
        System.out.println(solution(A, 8));


    }
}
