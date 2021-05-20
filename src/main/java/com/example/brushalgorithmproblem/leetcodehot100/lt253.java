package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 11:20 下午
 */
//会议室II
public class lt253 {

//    https://michael.blog.csdn.net/article/details/107189220
//    https://www.cnblogs.com/grandyang/p/5244720.html

//    贪心

    //    使用TreeMap 在一个时间轴对问题进行模拟，并进行了数学上的化简
    public static int minMeetingRooms(List<int[]> list) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

//        起点+1，终点-1  计算在某个时间节点要开启或者关闭的会议室数目
        for (int[] ele : list) {
            map.put(ele[0], map.getOrDefault(ele[0], 0) + 1);
            map.put(ele[1], map.getOrDefault(ele[1], 0) - 1);
        }

        Integer rooms = 0, res = 0;

//        遇到某个时间节点开始就加上要开始的数目 遇到某个时间节点终止就减去要结束的数目
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            rooms += entry.getValue();
            res = Math.max(res, rooms);
        }

        return res;
    }

    //    堆排序
    public static int minMeetingRooms1(List<int[]> list) {

        int[][] lists = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            lists[i] = list.get(i);
        }

//        自定义排序
        Arrays.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

//        顺序排序 比较器的变量顺序前后成顺序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                顺序排序 比较器的变量顺序前后成顺序
                return o1 - o2;
            }
        });

//        优先队列中只放结束的时间
        for (int[] ele : lists) {
//            queue中存放的结束时间早于目前遍历到的ele的开始时间 说明有一个会议空了出来
            if (!queue.isEmpty() && queue.peek() <= ele[0]) {
                queue.poll();
            }
            queue.offer(ele[1]);
        }

        return queue.size();
    }


    public static void main(String[] args) {

        int[] i1 = new int[]{0, 30};
        int[] i2 = new int[]{5, 10};
        int[] i3 = new int[]{15, 20};

        int[] i4 = new int[]{7, 10};
        int[] i5 = new int[]{2, 4};


        List l1 = new ArrayList();
        List l2 = new ArrayList();

        l1.add(i3);
        l1.add(i2);
        l1.add(i1);

        l2.add(i4);
        l2.add(i5);

        System.out.println(minMeetingRooms(l1));
        System.out.println(minMeetingRooms(l2));

        System.out.println();

        System.out.println(minMeetingRooms1(l1));
        System.out.println(minMeetingRooms1(l2));

    }

}
