package com.example.brushalgorithmproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/30 10:24 上午
 */

//最多可以参加的会议数目
public class lt1353 {

    //    贪心策略  同一天选择结束时间最早的参加 这样剩下的会议就保存了以后再参加的可能
    public static int maxEvents(int[][] events) {

//        按照开始时间排序
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
//        i是会议数组的下标 代表哪个会议的结束时间加入堆
        int count = 0, startDay = 1, i = 0;
        PriorityQueue<Integer> canJoin = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        while (i < events.length || !canJoin.isEmpty()) {

//            清除堆中的过期数据
            while (!canJoin.isEmpty() && canJoin.peek() < startDay) {
                canJoin.poll();
            }

//            往堆中添加元素 添加的是会议的结束时间
            while (i < events.length && events[i][0] <= startDay) {
                canJoin.add(events[i++][1]);
            }

//            参加结束时间最早的会议
            if (!canJoin.isEmpty()) {
                canJoin.poll();
                count++;
            }

//            日期往后推
            startDay++;

        }

        return count;
    }

    public static void main(String[] args) {

        int[][] events = new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        System.out.println(maxEvents(events));

        int[][] events1 = new int[][]{{2, 100000}};
        System.out.println(maxEvents(events1));


    }

}