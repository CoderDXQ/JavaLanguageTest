package com.example.brushalgorithmproblem;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/23 3:08 下午
 */
public class lt692 {

    //    哈希表排序
    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

//        自定义排序
        List<String> result = new ArrayList<>(map.keySet());

        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                数量相等比较字符串字典序
                if (map.get(o1).equals(map.get(o2))) {
                    return o1.compareTo(o2);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        });

        return result.subList(0, k);
    }

    //    优先队列  堆
    public static List<String> topKFrequent1(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

//        自定义堆 小根堆
        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

//        可以加个判断优化
        for (String word : map.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

//        调用集合的翻转方法
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

        String[] s1 = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] s2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        for (String s : topKFrequent(s1, 2)) {
            System.out.println(s + " ");
        }
        System.out.println();

        for (String s : topKFrequent(s2, 4)) {
            System.out.println(s + " ");
        }
        System.out.println();

        for (String s : topKFrequent1(s1, 2)) {
            System.out.println(s + " ");
        }
        System.out.println();

        for (String s : topKFrequent1(s2, 4)) {
            System.out.println(s + " ");
        }
        System.out.println();


    }

}
