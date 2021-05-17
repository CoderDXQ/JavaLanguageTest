package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:38 下午
 */
//课程表 拓扑排序问题
public class lt207 {

    //    整个大模拟
    //    倒排索引遍历 可能存在问题：一个课程依赖了多个课程，这里需要加以控制
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

//        特判
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

//        倒排 key影响的value
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

//        正排 key依赖的value
        HashMap<Integer, List<Integer>> hashMap1 = new HashMap<>();

//        转存 生成两张表
        for (int[] ele : prerequisites) {

            if (hashMap.containsKey(ele[1])) {
                hashMap.get(ele[1]).add(ele[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ele[0]);
                hashMap.put(ele[1], list);
            }

            if (hashMap1.containsKey(ele[0])) {
                hashMap1.get(ele[0]).add(ele[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ele[1]);
                hashMap1.put(ele[0], list);
            }

        }

        HashSet<Integer> set = new HashSet<>();
//        没有考虑多依赖的情况 i是迭代器，使用后会回收
//        ？？？这个条件可能需要换换  循环：转存的表不会变空
        while (set.size() < numCourses) {

            Integer num = null;

//            添加记录
            for (int i = 0; i < numCourses; i++) {
//                排除检索过的
                if (set.contains(i)) {
                    hashMap1.remove(i);
                    continue;
                }
//                找到要消去的依赖也是要上的课
                if (!hashMap1.containsKey(i) || hashMap1.get(i) == null) {
                    set.add(i);
                    num = i;
                    hashMap1.remove(i);
                    break;
                }
            }

//            找不到要上的课说明就是循环了
            if (num == null) {
                return false;
            }

//            num影响的课程
            List<Integer> list = hashMap.get(num);
            if (list == null) {
                continue;
            }
//            消去依赖num
            for (int k : list) {
//               ？？？ 不确定删除的是元素还是下标
                List<Integer> l = hashMap1.get(k);
                if (l != null) {
                    l.remove(num);
                }
                if (l.size() == 0 || l == null) {
                    hashMap1.remove(k);
                }
            }

        }

//        System.out.println();
//        只设置false的判断条件 其余的全是true
        return set.size() == numCourses ? true : false;
    }

    //    DFS
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {


        return true;
    }


    //    BFS
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {


        return true;
    }


    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{1, 0}};
        int numCourses = 2;

        int[][] prerequisites1 = new int[][]{{1, 0}, {0, 1}};
        int numCourses1 = 2;


        int[][] prerequisites2 = new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        int numCourses2 = 20;
        System.out.println(canFinish(numCourses2, prerequisites2));

        System.out.println();

        System.out.println(canFinish(numCourses, prerequisites));
        System.out.println(canFinish1(numCourses, prerequisites));
        System.out.println(canFinish2(numCourses, prerequisites));


        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println(canFinish1(numCourses1, prerequisites1));
        System.out.println(canFinish2(numCourses1, prerequisites1));

    }

}
