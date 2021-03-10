package com.example.datastructure.heap;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 2:11 上午
 */

//手写最大堆 参考：https://www.cnblogs.com/-beyond/p/13084115.html
public class MaxHeap {

    //    存放元素的数组  使用完全二叉树来实现
    private int[] elements;

    //    大小
    private int size;

    //    容量
    private int capacity;

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //    初始化
    public MaxHeap() {
        this.size = 0;
        this.capacity = 0;
    }

    public MaxHeap(int[] elements, int size, int capacity) {
        this.elements = elements;
        this.size = size;
        this.capacity = capacity;
    }

    /**
     * 建堆并调整
     */
    public void createMaxHeap() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入堆的最大容量：");
        this.capacity = scanner.nextInt();
        ;
        this.size = 0;

//        数组长度为数组容量+1 0号元素是哨兵元素
        this.elements = new int[this.capacity + 1];
        this.elements[0] = Integer.MAX_VALUE;

        System.out.println("请输入元素个数：");
        this.size = scanner.nextInt();

        if (this.size > this.capacity) {
            throw new RuntimeException("元素个数不能超过最大容量");
        }

        System.out.println("请输入" + this.size + "个元素");
        for (int i = 1; i <= this.size; i++) {
            elements[i] = scanner.nextInt();
        }

//        建堆
        buildHeap();
        System.out.println("已完成堆的建立和调整");

    }

    /**
     * 建堆
     * 建堆有两种方案：
     * 一是建立空堆然后进行n次插入，这样时间复杂度是O(N*logN) 放弃
     * 二是先顺序输入，满足完全二叉树的要求，在进行堆调整，满足有序性，时间复杂度O(N)
     */
    public void buildHeap() {
        if (isEmpty()) {
            throw new RuntimeException("堆为空，无法完成建堆操作");
        }

//        从下往上调整所有的非叶节点（父节点）
        for (int i = size / 2; i > 0; i--) {
//            System.out.println(i);
            adjustHeap(i);
        }

    }

    /**
     * 调整堆
     *
     * @param root
     */
    public void adjustHeap(int root) {

//        取出根节点存放的值
        int parentVal = elements[root];

//        这个变量代表根节点的值应该插入的位置
        int parentIndex = root;
//        向下调整 当这个while循环调整完毕时 parentVal的值的位置就不会变化了
        while (parentIndex * 2 <= size) {
            int childIndex = parentIndex * 2;
//            System.out.println(childIndex);
//            找到两个子节点中最大的子节点位置
            if (childIndex != size && elements[childIndex] < elements[childIndex + 1]) {
                childIndex++;
            }

//            父节点数值大于子节点 退出循环
            if (parentVal > elements[childIndex]) {
                break;
            } else {
//                父节点存放父节点和子节点中的最大值
                elements[parentIndex] = elements[childIndex];

//                如果发生了调整就要继续向下调整

            }
            parentIndex = childIndex;
        }

//        当前的父节点位置存放本次调整的根节点原来的值
        elements[parentIndex] = parentVal;
    }

    /**
     * 向最大堆中插入一个元素
     *
     * @param newItem
     */
    public void insertElement(int newItem) {
        if (isFull()) {
            throw new RuntimeException("堆已满，无法继续添加元素");
        }

//        默认将新元素放在最后 然后向上调整 这个变量代表新节点要插入的位置
        int nextIndex = this.size++;

//        如果大于就不需要调整  小于才需要调整 往上进行调整
        while (elements[nextIndex / 2] < newItem) {//父节点值小于新插入的值 往上调整寻找更大的父节点值
            elements[nextIndex] = elements[nextIndex / 2];
//            修改新节点准备插入的位置
            nextIndex /= 2;
        }

//        插入新值 此时这个值比父节点小，比子节点都大
        elements[nextIndex] = newItem;
    }

    /**
     * 删除堆顶元素
     */
    public int deleteMaxItem() {
        if (isEmpty()) {
            throw new RuntimeException("堆为空，不能进行删除操作");
        }

//        堆顶元素
        int maxItem = elements[1];

//        将最后一个元素取出来放到堆顶然后再向下进行调整
        int lastItem = elements[size];
        elements[size] = 0;
        size--;

//        这个变量表示最后一个元素应该存放的位置 最后一个元素被从最后移到了堆顶
        int insertIndex = 1;

//        将最后一个元素放到堆顶后进行调整
        while (insertIndex * 2 <= size) {
//            左孩子 向下走
            int childIndex = insertIndex * 2;
//            childIndex指向值最大的孩子节点
            if (childIndex != size && elements[childIndex] < elements[childIndex + 1]) {
                childIndex++;
            }

//            最后一个元素大于指向的元素 证明找到了插入的位置  中断循环
            if (lastItem >= elements[childIndex]) {
                break;
            } else {
                elements[insertIndex] = elements[childIndex];
                insertIndex = childIndex;
            }
        }

        elements[insertIndex] = lastItem;
        return maxItem;
    }

    public void printSortedHeap() {
        for (int i = 1; i <= this.size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return this.size >= capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
