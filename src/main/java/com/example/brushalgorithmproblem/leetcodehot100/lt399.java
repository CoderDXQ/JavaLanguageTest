package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:23 下午
 */
//除法求值
public class lt399 {

//    转化为图论问题 实际上就是求两个点之间是否连通

    //    DFS
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


        return null;
    }

    //    带权并查集
    public static double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {


        return null;
    }

    //    Floyd算法
    public static double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {


        return null;
    }

    //    BFS
    public static double[] calcEquation3(List<List<String>> equations, double[] values, List<List<String>> queries) {


        return null;
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();

        List<String> l1 = new ArrayList<String>();
        l1.add("a");
        l1.add("b");

        List<String> l2 = new ArrayList<String>();
        l1.add("b");
        l1.add("c");

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
            System.out.printf("%.5f", d);
        }
        System.out.println();

        for (double d : calcEquation1(equations, values, queries)) {
            System.out.printf("%.5f", d);
        }
        System.out.println();

        for (double d : calcEquation2(equations, values, queries)) {
            System.out.printf("%.5f", d);
        }
        System.out.println();

        for (double d : calcEquation3(equations, values, queries)) {
            System.out.printf("%.5f", d);
        }
        System.out.println();

    }

}
