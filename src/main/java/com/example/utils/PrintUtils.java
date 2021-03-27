package com.example.utils;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 2:58 下午
 */
public class PrintUtils {


    /**
     * 打印数组元素
     * 传进来的数组必须是包装类
     * 之所以用包装类是因为有些数据可能返回null，某些基本数据类型没有null，包装类是对象，可以返回null
     * 能用基本数据类型就用基本数据类型，基本数据类型是放在栈中的，包装类对象是放在堆中的，栈中的创建和销毁要比堆中的快很多
     *
     * @param array
     * @param <T>
     */
    public static <T> void printArray(T[] array) {
        for (T o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


}
