package com.example.brushalgorithmproblem.template;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/29 4:43 下午
 */


//并查集
public class UnionFind {
    private int[] parent;
    private int[] rank;

    //    利用构造函数进行初始化
    UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        this.rank = new int[n];
    }

    //    找爹
    int find(int idx) {
        while (parent[idx] != idx) idx = parent[idx];
        return idx;
    }


    //    合并
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
