package com.example.writtenexaminationandinterview.huawei;

import java.util.*;

public class t1 {

    public static class UnionFind {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nn=n;
//        吸收换行符
        in.nextLine();

        boolean first = true;

        HashMap<String, Integer> nametonum = new HashMap<>();
        HashMap<Integer, Integer> relation = new HashMap<>();

        int k = 0;
        while (n > 0) {
            String line = in.nextLine();

            String[] names = line.split(" ");

            String name1 = names[0];
            String name2 = names[1];

            if (!nametonum.containsKey(name1)) {
                nametonum.put(name1, k++);
            }
            if (!nametonum.containsKey(name2)) {
                nametonum.put(name2, k++);
            }

            relation.put(nametonum.get(name1), nametonum.get(name2));
            n--;
        }

//        进行并查集处理

        UnionFind unionFind = new UnionFind(nametonum.size());

        for (Integer key : relation.keySet()) {
            unionFind.union(key, relation.get(key));
        }

        Set<Integer> set = new HashSet<>();
        for (Integer i : unionFind.parent) {
            set.add(i);
        }

        if (nn == 1) {
            System.out.println(1);
        } else if (nn <= 0) {
            System.out.println(0);
        } else if(nn>1){
            System.out.println(set.size());
        }

    }
}
