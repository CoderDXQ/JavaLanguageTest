package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:29 下午
 */

//滑动窗口最大值
public class lt239 {

    //    优先队列
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
//        定义优先队列 堆 自定义排序规则
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
//            i在后面用来判断是不是划出了窗口
            queue.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];

        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
//            将划出窗口的最值从队列里弹出  这里实际上是在检验当前队列里最值得合法性
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        return ans;
    }

    //    单调队列 基本的数据结构是双向队列  双向队列还用来实现LRU
    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
//            构造单调队列
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
//            添加到后面
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {

//            往单调队列里添加元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

//            从单调队列里删除划出窗口的元素
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    // 分块+预处理 Sparse Table  ST算法 稀疏表法 适用于区间最值查询
//    将数组分成大小为k的块，那么每次窗口的查询结果都可以从相邻的一个或者两个块的最大值中得到
//    需要画图理解一下 https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
    public static int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

//        预处理
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(nums[i], prefix[i - 1]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if ((i + 1) % k == 0 || i + 1 == n) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = Math.max(nums[i], suffix[i + 1]);
            }
        }

//        计算
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
//            滑动窗口的最值只在相邻两块的前缀最大值和后缀最大值之间
//            后一块的前缀和前一块的后缀 相邻的两块
            ans[i] = Math.max(prefix[i + k - 1], suffix[i]);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        for (int i : maxSlidingWindow(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : maxSlidingWindow1(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : maxSlidingWindow2(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
