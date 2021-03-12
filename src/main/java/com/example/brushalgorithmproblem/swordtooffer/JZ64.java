package com.example.brushalgorithmproblem.swordtooffer;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 11:36 下午
 */
public class JZ64 {

    //    单调队列 使用队列来维护窗口  队列中存放元素在数组中的下标
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length == 0 || size > num.length) {
            return result;
        }
//        队列中存放元素下标
        Deque<Integer> deque = new ArrayDeque<>();

        int max = Integer.MIN_VALUE;
        int indexOfMax = -1;
        for (int i = 0; i < num.length; i++) {
            deque.addLast(i);
//            滑动窗口不满
            if (deque.size() <= size) {
//                存放下标
                if (max < num[i]) {
                    max = num[i];
                    indexOfMax = i;
                }
                if (deque.size() == size) {
                    result.add(num[indexOfMax]);
                }
            } else {
//                滑动窗口满了
                deque.pollFirst();
                if (max < num[i]) {
                    max = num[i];
                    indexOfMax = i;
                }
//                indexOfMax的过期问题？？？
                if (indexOfMax <= i - size) {
//                    重选indexOfMax
                    Iterator<Integer> iterator = deque.iterator();
                    max = Integer.MIN_VALUE;
                    while (iterator.hasNext()) {
                        int k = iterator.next();
                        if (max <= num[k]) {
                            max = num[k];
                            indexOfMax = k;
                        }
                    }
                }
                result.add(num[indexOfMax]);
            }
        }
        return result;
    }

    //    堆(优先队列) 使用堆来维护窗口
    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length == 0 || size > num.length) {
            return result;
        }
//        定义成大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(size, (i1, i2) -> Integer.compare(i2, i1));
        for (int i = 0; i < num.length; i++) {
            if (priorityQueue.size() < size) {
                priorityQueue.add(num[i]);
            } else {
                result.add(priorityQueue.peek());
                priorityQueue.remove(num[i - size]);
                priorityQueue.add(num[i]);
            }
        }
        result.add(priorityQueue.poll());
        return result;
    }

    //    单调队列的优化写法 消消算法 使用队列来维护窗口  队列中存放元素在数组中的下标
    public static ArrayList<Integer> maxInWindows3(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length == 0 || size > num.length) {
            return result;
        }
//        存放下标
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
//            从后面消去窗口队列中小于新进入的数的数
            while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
//            过期处理
            while (!deque.isEmpty() && deque.peekFirst() + size <= i) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                result.add(num[deque.peekFirst()]);
            }
        }
        return result;
    }

    //    不用实体来维护窗口
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length == 0 || size > num.length) {
            return result;
        }

        int left = 0, right = size - 1, max = Integer.MIN_VALUE, index = -1;
//        分两种情况 index过期和不过期 滑动窗口不满时也认为是不过期
        while (right < num.length) {
            if (index >= left && index <= right) {
//                处理窗口中的新值与最大值的关系
                if (max <= num[right]) {
                    max = num[right];
                    index = right;
                }
            } else {
//                重新找max和index
                max = Integer.MIN_VALUE;
                index = -1;
                for (int i = left; i <= right; i++) {
                    if (max < num[i]) {
                        max = num[i];
                        index = i;
                    }
                }
            }
            left++;
            right++;
            result.add(max);
        }
        return result;
    }

    //    Sparse Table算法  区间最值查询的在线算法 ？？？以后再补充
    public static ArrayList<Integer> maxInWindows5(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length == 0 || size > num.length) {
            return result;
        }


        return result;
    }


    public static void main(String[] args) {
        int[] num = new int[]{16, 14, 12, 10, 8, 6, 4};
        int size = 5;

        maxInWindows(num, size).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        maxInWindows1(num, size).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        maxInWindows2(num, size).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        maxInWindows3(num, size).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

//        Sparse Table算法暂时没有实现
//        maxInWindows5(num, size).forEach(System.out::print);
//        System.out.println();

    }
}
