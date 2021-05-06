package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/8 6:29 下午
 */

//最小的K个数
//堆排序的时间复杂度分析：https://blog.csdn.net/YuZhiHui_No1/article/details/44258297
public class JZ29 {

    //    直接使用java集合 优先队列
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || k > input.length || k <= 0) {
            return list;
        }

//        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
//        设置堆的排序规则 大根堆
        Queue<Integer> heap = new PriorityQueue<>(k, (a, b) -> Integer.compare(b, a));

        for (int e : input) {
            if (heap.size() == k) {
                if (e < heap.peek()) {
                    heap.poll();
                    heap.add(e);
                }
            } else {
                heap.add(e);
            }
        }

        list.addAll(heap);
        return list;
    }

    //    手写堆排序  大根堆
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k == 0)
            return list;
        int[] arr = new int[k + 1];//数组下标0的位置作为哨兵，不存储数据
        //初始化数组
        for (int i = 1; i < k + 1; i++)
            arr[i] = input[i - 1];
        buildMaxHeap(arr, k + 1);//构造容量为k的大根堆
        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[1]) {
                arr[1] = input[i];
                adjustDown(arr, 1, k + 1);//将改变了根节点的二叉树继续调整为大根堆
            }
        }
        for (int i = 1; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * @Author: ZwZ
     * @Description: 构造大根堆 使用数组来静态实现完全二叉树  优先队列的底层的树是完全二叉树
     * @Param: [arr, length]  length:数组长度 作为是否跳出循环的条件
     * @return: void
     * @Date: 2020/1/30-22:06
     */
    public static void buildMaxHeap(int[] arr, int length) {
        if (arr == null || arr.length == 0 || arr.length == 1)
            return;
//        将非叶节点分别移到最后一个节点来进行调整就能达到建树的目的
        for (int i = (length - 1) / 2; i > 0; i--) {//(length - 1) / 2  这是最后一个父节点的位置
            adjustDown(arr, i, arr.length);
        }
    }

    /**
     * @Author: ZwZ
     * @Description: 堆排序中对一个子二叉树进行堆排序
     * @Param: [arr, k, length]
     * @return:
     * @Date: 2020/1/30-21:55
     */
    public static void adjustDown(int[] arr, int k, int length) {
        arr[0] = arr[k];//哨兵 arr[0]实际就是起了交换两个变量的值的方法中的temp的作用
        for (int i = 2 * k; i <= length; i *= 2) {
            if (i < length - 1 && arr[i] < arr[i + 1])
                i++;//取k较大的子结点的下标 切换到右孩子 取左右孩子中的节点最大值
            if (i > length - 1 || arr[0] >= arr[i])
                break;
            else {
                arr[k] = arr[i];//是父节点存放最大值
                k = i; //向下筛选
            }
        }
        arr[k] = arr[0];
    }


    public static void main(String[] args) {

        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;

        GetLeastNumbers_Solution(input, k).forEach(x -> System.out.print(x + " "));
        System.out.println();

        GetLeastNumbers_Solution1(input, k).forEach(System.out::print);

    }

}
