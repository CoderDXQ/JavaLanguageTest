package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/1 2:15 下午
 */
//根据身高重建队列
public class lt406 {

    //   贪心策略 从低到高
    public static int[][] reconstructQueue(int[][] people) {

//        按照数值从小到大排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });


        int n = people.length;
        int[][] ans = new int[n][];

        for (int[] person : people) {

//            比这个数大的都在这个数前面 并且数组是按数值从小到大排序的 所以 space的位置是可以确定的
            int space = person[1] + 1;
            for (int i = 0; i < n; i++) {
//                计数space个空位然后放置当前元素 因为后面的元素都比当前元素大  所以空出这些位置来即可
                if (ans[i] == null) {
                    --space;
                    if (space == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    //  贪心策略  从高到低
    public static int[][] reconstructQueue1(int[][] people) {

//        从大到小排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
//            内部是头插法 所以后面小的数插入之后对前面大的数没有影响
            ans.add(person[1], person);
        }
//        链表变数组
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {

        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        for (int[] person : reconstructQueue(people)) {
            System.out.print("[" + person[0] + "," + person[1] + "],");

        }
        System.out.println();

        for (int[] person : reconstructQueue1(people)) {
            System.out.print("[" + person[0] + "," + person[1] + "],");

        }
        System.out.println();

    }

}
