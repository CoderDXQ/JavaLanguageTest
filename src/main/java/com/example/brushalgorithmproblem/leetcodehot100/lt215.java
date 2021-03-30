package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.PriorityQueue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 9:45 下午
 */

//数组中第k个最大元素
public class lt215 {

    //    基于快速排序的方法 ???要好好的再理解下这个过程
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;

        while (true) {
            int index = Partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

    }

    //    减治
    public static int Partition(int[] nums, int left, int right) {

//        基准兵
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
//                小于pivot的都换到pivot前面
                j++;
                swap(nums, j, i);
            }
        }

//        基准兵就位 此时满足[left+1,j]<pivot，并且(j,i]>=pivot
        swap(nums, j, left);
//        j和j之前的都是有序的
        return j;

    }

    //    手写堆排序 ？？？需要再理解一下
    public static int findKthLargest1(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
//        在这个堆中 下标为0的数是最大值
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
//            把最大的值换到最后面  然后堆大小-1  这样就不会再考虑这个最大值
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    //    建堆  这里的堆实际上是一棵完全二叉树
    public static void buildMaxHeap(int[] a, int heapSize) {
//        建堆只需要调整所有父节点即可 叶子结点无需进行调整  在进行调整选举新的父节点时会与其进行比较
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    //    调整
    public static void maxHeapify(int[] a, int i, int heapSize) {

//        i是父节点下标
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;

//        跟左右子节点相比找出最大的来当父节点
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(a, i, largest);
//            继续向下调整
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //     直接使用有点队列  底层原理就是堆 小顶堆解法
    public static int findKthLargest2(int[] nums, int k) {

//        小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);

        for (int i : nums) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                if (queue.peek() < i) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }

        return queue.peek();
    }


    //    使用优先队列  大顶堆
    public static int findKthLargest3(int[] nums, int k) {
//        大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length - k + 1, (a, b) -> b - a);
        for (int n : nums) {
            if (queue.size() < nums.length - k + 1) {
                queue.offer(n);
            } else {
                if (queue.peek() > n) {
                    queue.poll();
                    queue.offer(n);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest1(nums, k));
        System.out.println(findKthLargest2(nums, k));
        System.out.println(findKthLargest3(nums, k));

    }

}
