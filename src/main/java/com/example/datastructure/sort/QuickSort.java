package com.example.datastructure.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/10 5:16 下午
 */

//快速排序的递归和非递归实现
public class QuickSort {

    //    递归实现
    public static void QuickSort(int left, int right, int[] array) {
        int i = left, j = right, mid = (left + right) >> 1;
        while (i <= j) {
            while (array[i] < array[mid]) {
                i++;
            }
            while (array[j] > array[mid]) {
                j--;
            }
            if (i <= j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
//                    交换完之后下标还要继续向下走
                i++;
                j--;
            }
        }
        if (left < j) {
            QuickSort(left, j, array);
        }
        if (right > i) {
            QuickSort(i, right, array);
        }
    }


    //    非递归实现 实际上就是用栈来模拟递归时的栈
    public static void QuickSort1(int left, int right, int[] array) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(left, right));
//        利用栈来模拟递归
        while (!stack.empty()) {
            Pair<Integer> pair = stack.pop();
            int i = pair.first, j = pair.second;
            int mid = (i + j) >> 1;
//            System.out.println("i= " + i + " j= " + j + " mid= " + mid);
//            一直到i>j 此时才能再次划分区间
            while (i <= j) {
                while (array[i] < array[mid]) {
                    i++;
                }
                while (array[j] > array[mid]) {
                    j--;
                }

                if (i <= j) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                    i++;
                    j--;
                }
            }
//            因为没有使用递归  所以这里的left right变量是不会变的 应该进行替换
            if (pair.first < j) {
                stack.push(new Pair(pair.first, j));
            }
            if (i < pair.second) {
                stack.push(new Pair(i, pair.second));
            }
        }
    }

    //    内部类
    public static class Pair<T> {
        T first;
        T second;

        public Pair() {
        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }


    //    非递归实现 实际上就是用栈来模拟递归时的栈 不使用内部类来存放数对
    public static void QuickSort2(int left, int right, int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            int r = stack.pop(), l = stack.pop(), mid = (l + r) >> 1, j = r, i = l;

            while (i <= j) {
                while (array[i] < array[mid]) {
                    i++;
                }
                while (array[j] > array[mid]) {
                    j--;
                }
                if (i <= j) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                    i++;
                    j--;
                }
            }
            if (l < j) {
                stack.push(l);
                stack.push(j);
            }
            if (i < r) {
                stack.push(i);
                stack.push(r);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 3, 2, 5, 6, 1};

        QuickSort(0, array.length - 1, array);

        Arrays.stream(array).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();


        int[] array1 = new int[]{1, 4, 3, 2, 5, 6, 1};

        QuickSort1(0, array1.length - 1, array1);
        Arrays.stream(array1).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        int[] array2 = new int[]{1, 4, 3, 2, 5, 6, 1};

        QuickSort2(0, array2.length - 1, array2);
        Arrays.stream(array2).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();


    }
}
