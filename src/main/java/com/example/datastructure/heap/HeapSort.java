package com.example.datastructure.heap;


/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/27 1:32 下午
 */


public class HeapSort {

    //    建堆
    private static void heapsort(int[] arr) {
        int len = arr.length;
//        建堆 len / 2 - 1 是最后一个父节点在在数组中的下标  建好的这个堆并不是二叉排序树只是根节点是最大值（仅仅是一个大根堆）
        for (int i = len / 2 - 1; i > -1; i--) {
            heapAdjust(arr, i, len);
        }


        for (int ii = 0; ii < arr.length; ii++) {
            System.out.print(arr[ii] + " ");
        }
        System.out.println();


        for (int i = len - 1; i > 0; i--) {
            swap(arr, i, 0);
//            i是需要调整的数组的长度-1，也是此次调整的堆的根节点的下标
            heapAdjust(arr, 0, i);

            for (int ii = 0; ii < arr.length; ii++) {
                System.out.print(arr[ii] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //    交换
    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    //    堆调整
    private static void heapAdjust(int[] arr, int s, int length) {
        int temp = arr[s];
        for (int j = 2 * s + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (temp > arr[j]) {
                break;
            }
            arr[s] = arr[j];
            s = j;
        }
//        System.out.println(temp);
        arr[s] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 3, 5, 6, 7, 9};
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < 8; i++) {
//            if (in.hasNext()) {
//                arr[i] = (int) in.nextInt();
//            }
//        }

        System.out.println(arr);

        heapsort(arr);

    }
}
