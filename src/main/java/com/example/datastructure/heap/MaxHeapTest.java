package com.example.datastructure.heap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 5:32 下午
 */
public class MaxHeapTest {

    public static void shuchu(int[] pr) {
        System.out.println("第0个元素是哨兵元素");
        for (int i = 0; i < pr.length; i++) {
            System.out.print(pr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        手动创建最大堆
//        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.createMaxHeap();

//        直接创建最大堆 第0个元素是哨兵元素 需要填充
        int[] elements = new int[]{Integer.MAX_VALUE, 2, 3, 4, 5, 1};
        MaxHeap maxHeap = new MaxHeap(elements, 5, 6);

//        建堆
        maxHeap.buildHeap();

        System.out.println("输出堆：");
        maxHeap.printSortedHeap();
        System.out.println();

        while (maxHeap.getSize() > 0) {
            int[] pr = maxHeap.getElements();
            shuchu(pr);
            System.out.println(maxHeap.deleteMaxItem());
        }

    }
}
