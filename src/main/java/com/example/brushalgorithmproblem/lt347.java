package com.example.brushalgorithmproblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 4:22 下午
 */

//前k个高频元素
public class lt347 {
    //    堆   ???后期用键值对改造一下？？？
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i : nums) {
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }

//        定义堆 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

//        使用键值对遍历
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (queue.size() == k) {

                if (count >= queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }

            } else {
                queue.add(new int[]{num, count});
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }

    //    基于快速排序？？？
    public static int[] topKFrequent1(int[] nums, int k) {

        return null;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        for (int i : topKFrequent(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : topKFrequent(new int[]{1}, 1)) {
            System.out.print(i + " ");
        }
        System.out.println();

//        for (int i : topKFrequent1(nums, k)) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        for (int i : topKFrequent1(new int[]{1}, 1)) {
//            System.out.print(i + " ");
//        }
//        System.out.println();


    }

}
