package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/15 4:22 下午
 */

//前k个高频元素
public class lt347 {
    //    堆
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


    //    结构体
    static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    //    基于快速排序
    public static int[] topKFrequent1(int[] nums, int k) {

//        统计频率
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

//        构造Pair数组
        Pair[] pairs = new Pair[hashMap.size()];
        int i = 0;
        for (Integer key : hashMap.keySet()) {
            pairs[i++] = new Pair(key, hashMap.get(key));
        }

//        调用快排
        int len = pairs.length;
        int idx = len - k;
        quickSort(pairs, 0, len - 1, idx - 1);
//        截取结果
        Pair[] topKPairs = Arrays.copyOfRange(pairs, len - k, pairs.length);

//        构造返回结果
        int[] res = new int[k];
        i = 0;
        for (Pair p : topKPairs) {
            res[i++] = p.num;
        }

        return res;
    }

    public static void quickSort(Pair[] pairs, int left, int right, int idx) {

//        排序结束
        if (left >= right) {
            return;
        }

        int mid = partition(pairs, left, right);

//        找到区间
        if (mid == idx) {
            return;
        }

//        个数不够 没有排好
        if (mid < idx) {
            quickSort(pairs, mid + 1, right, idx);
        } else {
//            个数多了
            quickSort(pairs, left, mid - 1, idx);
        }

    }

    public static int partition(Pair[] pair, int left, int right) {

        Pair temp = pair[left];
        Pair t;
        int i = left, j = right;

        while (i < j) {

            while (i < j && temp.freq <= pair[j].freq) {
                j--;
            }

            while (i < j && temp.freq >= pair[i].freq) {
                i++;
            }

            if (i < j) {
                t = pair[i];
                pair[i] = pair[j];
                pair[j] = t;
            }

        }

//        哨兵就位
        pair[left] = pair[i];
        pair[i] = temp;

//        返回已经过滤好的位置
        return i;

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

        System.out.println();

        for (int i : topKFrequent1(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : topKFrequent1(new int[]{1}, 1)) {
            System.out.print(i + " ");
        }
        System.out.println();


    }

}
