package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:38 下午
 */
//课程表 拓扑排序问题
public class lt207 {

    //    整个大模拟 本质上还是BFS
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
        while (set.size() < numCourses) {

            Integer num = null;

//            寻找可以上的课
            for (int i = 0; i < numCourses; i++) {
//                排除检索过的 添加记录
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
//            消去依赖num 其实并不需要知道具体依赖了谁 只需要知道依赖度即可
            for (int k : list) {
                List<Integer> l = hashMap1.get(k);
                if (l != null) {
                    l.remove(num);
                }
                if (l.size() == 0 || l == null) {
                    hashMap1.remove(k);
                }
            }

        }

//        只设置false的判断条件 其余的全是true
        return set.size() == numCourses;
    }

    //    邻接表
    public static List<List<Integer>> edges;
    public static int[] visited;
    public static boolean valid;

    //    DFS 使用回溯标记状态
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
//        初始化
        valid = true;
        //        建立邻接表
        edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

//        找到没有被处理过的点进行处理  这里的处理类似于在图中搜索所有的连通块
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    /**
     * visited[]的值为：
     * 0代表未搜索
     * 1代表正在搜索，如果此时又搜索到这个点 说明形成了环
     * 2 代表搜索已完成
     *
     * @param u
     */
    public static void dfs(int u) {
//        标记为正在处理
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
//                剪枝 已经检查到环了 直接返回
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
//                成环了
                valid = false;
                return;
            }
        }
//        回溯  递归完成 标记为完成状态
        visited[u] = 2;
    }


    //    入度统计数组
    public static int[] indeg;

    //    BFS 是对模拟方法的抽象
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
//        创建邻接表
        edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];

//        构建邻接表并计算入度
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
//            入度或者说是依赖度计算
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

//        所有入度为0的点入队
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
//            处理所有被影响的点
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
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
        System.out.println();

        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println(canFinish1(numCourses1, prerequisites1));
        System.out.println(canFinish2(numCourses1, prerequisites1));

    }

}
