package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:23 下午
 */
//除法求值 图论问题
public class lt399 {

    //    定义邻接表结点 存储了下一个节点的id和边的权值
    static class Node {
        public String id;
        //        权值
        public double num;

        //        构造方法
        public Node(String i, double n) {
            id = i;
            num = n;
        }
    }

    // 邻接表 存储图 java中邻接表的构造形式
    public static Map<String, List<Node>> map;

// 转化为图论问题 实际上就是求两个点之间是否连通

    // DFS
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        map = new HashMap<>();
        double[] res = new double[queries.size()];

//        处理图 构造邻接表  情况分为除数和被除数，应该按双向图来处理
        for (int i = 0; i < n; i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

//            为节点创建链表
            if (!map.containsKey(dividend)) {
                map.put(dividend, new ArrayList<>());
            }
            if (!map.containsKey(divisor)) {
                map.put(divisor, new ArrayList<>());
            }
//            往邻接表中添加数据
            map.get(dividend).add(new Node(divisor, values[i]));
            map.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

        int cnt = 0;
//        遍历所有查询
        for (List<String> q : queries) {
            res[cnt] = dfs(q.get(0), q.get(1), 1.0, new HashSet<>());
            cnt++;
        }
        return res;
    }

    private static double dfs(String cur, String dest, double knerl, HashSet<Object> set) {
//        这个节点不能去其他任何点或者这个点已经被遍历过了
        if (!map.containsKey(cur) || set.contains(cur)) {
            return -1.0;
        }
//        到达终点 返回值
        if (cur.equals(dest)) {
            return knerl;
        }
//        防止重复遍历成环
        set.add(cur);

//        遍历当前节点的邻接节点
        for (Node node : map.get(cur)) {
//            继续搜索
            double temp = dfs(node.id, dest, knerl * node.num, set);
//            -1.0说明这个节点已经被访问过或者不连通
            if (temp != -1.0) {
                return temp;
            }
        }
        return -1.0;
    }

    // 带权并查集
    public static double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

//        存放各自的爹
        int f[] = new int[nvars];
//        w[i]定义为节点x与其父节点的比值
        double[] w = new double[nvars];
//        初始化
        Arrays.fill(w, 1.0);
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
        }

//        初始化并查集
        for (int i = 0; i < n; i++) {
            int start = variables.get(equations.get(i).get(0));
            int end = variables.get(equations.get(i).get(1));
            merge(f, w, start, end, values[i]);
        }

//        处理查询
        int queriesCount = queries.size();
        double ret[] = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (variables.containsKey(start) && variables.containsKey(end)) {
                int numOfstart = variables.get(start);
                int numOfend = variables.get(end);
                int fatherOfStart = find(f, w, numOfstart);
                int fatherOfend = find(f, w, numOfend);
//                起点终点所在的连通块不连通
                ret[i] = fatherOfStart == fatherOfend ? w[numOfstart] / w[numOfend] : -1.0;
            } else {
//                不存在起点或终点
                ret[i] = -1.0;
            }
        }
        return ret;
    }

    //    合并认爹
    private static void merge(int[] f, double[] w, int x, int y, double value) {
        int fx = find(f, w, x);
        int fy = find(f, w, y);
//        认爹 fx的爹是fy
        f[fx] = fy;
        w[fx] = value * w[y] / w[x];
    }

    //    递归找爹
    private static int find(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = find(f, w, f[x]);
//            累积
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }

    //    Floyd算法 本质是三重循环
    public static double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
//        记录节点与其对应的序号
        Map<String, Integer> variables = new HashMap<>();

//        初始化variables和graph
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        double[][] graph = new double[nvars][nvars];
        for (int i = 0; i < nvars; i++) {
            Arrays.fill(graph[i], -1.0);
        }

        for (int i = 0; i < n; i++) {
            int start = variables.get(equations.get(i).get(0));
            int end = variables.get(equations.get(i).get(1));
            graph[start][end] = values[i];
            graph[end][start] = 1.0 / values[i];
        }

//        预处理
//        遍历中间节点
        for (int k = 0; k < nvars; k++) {
            for (int i = 0; i < nvars; i++) {
                for (int j = 0; j < nvars; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

//        处理查询请求
        int queriesCount = queries.size();
//        存放查询的结果
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (variables.containsKey(start) && variables.containsKey(end)) {
                int numOfstart = variables.get(start);
                int numOfend = variables.get(end);
//                起点终点都存在但不连通
                ret[i] = (graph[numOfstart][numOfend] > 0) ? graph[numOfstart][numOfend] : -1.0;
            } else {
//                起点终点不都存在
                ret[i] = -1.0;
            }
        }
        return ret;
    }

    //    BFS 超时
    public static double[] calcEquation3(List<List<String>> equations, double[] values, List<List<String>>
            queries) {
        int n = equations.size();
        map = new HashMap<>();
        double[] res = new double[queries.size()];

//        处理图 构造邻接表  情况分为除数和被除数，应该按双向图来处理
        for (int i = 0; i < n; i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            if (!map.containsKey(dividend)) {
                map.put(dividend, new ArrayList<>());
            }
            if (!map.containsKey(divisor)) {
                map.put(divisor, new ArrayList<>());
            }

            map.get(dividend).add(new Node(divisor, values[i]));
            map.get(divisor).add(new Node(dividend, 1 / values[i]));
        }

//        遍历每次查询
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            String start = query.get(0);
            String end = query.get(1);
            if (map.containsKey(start) && map.containsKey(end)) {
//                特判
                if (start == end) {
                    result = 1.0;
                } else {
//                    初始化
                    Queue<String> queue = new LinkedList<>();
                    queue.offer(start);
                    Map<String, Double> ratios = new HashMap<>();
                    ratios.put(start, 1.0);
                    ratios.put(end, -1.0);
//                队列非空且没有得到算式的答案
                    while (!queue.isEmpty() && ratios.get(end) < 0) {
                        String out = queue.poll();
                        for (Node node : map.get(out)) {
                            String toEnd = node.id;
                            double value = node.num;
//                        如果这里大于0 说明被计算过 此时不需要重复计算 因为 起点都是同一个
                            if (!ratios.containsKey(toEnd) || ratios.get(toEnd) < 0) {
                                ratios.put(toEnd, ratios.get(out) * value);
                                queue.offer(toEnd);
                            }
                        }
                    }
                    result = ratios.get(end);
                }
            }
//            起点或终点不存在的情况
            res[i] = result;
        }
        return res;
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<String>();
        l1.add("a");
        l1.add("b");
        List<String> l2 = new ArrayList<String>();
        l2.add("b");
        l2.add("c");
        equations.add(l1);
        equations.add(l2);

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        String[] s1 = new String[]{"a", "c"};
        String[] s2 = new String[]{"b", "a"};
        String[] s3 = new String[]{"a", "e"};
        String[] s4 = new String[]{"a", "a"};
        String[] s5 = new String[]{"x", "x"};
        List<String> ll1 = new ArrayList<>();
        for (String s : s1) {
            ll1.add(s);
        }
        queries.add(ll1);
        List<String> ll2 = new ArrayList<>();
        for (String s : s2) {
            ll2.add(s);
        }
        queries.add(ll2);
        List<String> ll3 = new ArrayList<>();
        for (String s : s3) {
            ll3.add(s);
        }
        queries.add(ll3);
        List<String> ll4 = new ArrayList<>();
        for (String s : s4) {
            ll4.add(s);
        }
        queries.add(ll4);
        List<String> ll5 = new ArrayList<>();
        for (String s : s5) {
            ll5.add(s);
        }
        queries.add(ll5);


        for (double d : calcEquation(equations, values, queries)) {
            System.out.printf("%10.5f", d);
        }
        System.out.println();

        for (double d : calcEquation1(equations, values, queries)) {
            System.out.printf("%10.5f", d);
        }
        System.out.println();

        for (double d : calcEquation2(equations, values, queries)) {
            System.out.printf("%10.5f", d);
        }
        System.out.println();

        for (double d : calcEquation3(equations, values, queries)) {
            System.out.printf("%10.5f", d);
        }
        System.out.println();

    }

}
