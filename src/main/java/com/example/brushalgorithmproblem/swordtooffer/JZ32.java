package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/7 11:55 下午
 */
//把数组排成最小的数
//字符串排序的比较也有两种方法：一是单个字符串循环进行比较 二是两个字符串分别首尾相接进行比较
public class JZ32 {

    //    贪心 自定义排序 排序可使用冒泡排序
    public static String PrintMinNumber1(int[] numbers) {

//        改写冒泡排序
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String str1 = numbers[i] + "" + numbers[j];
                String str2 = numbers[j] + "" + numbers[i];
//                大于
                if (str1.compareTo(str2) > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        String result = "";
        for (int i : numbers) {
            result += i;
        }
        return result;
    }

    //    贪心 自定义排序 排序可使用冒泡排序
    public static String PrintMinNumber(int[] numbers) {

        numbers = QuickSort(numbers, 0, numbers.length - 1);

        String result = "";
        for (int num : numbers) {
            result += num;
        }

        return result;
    }

    public static int[] QuickSort(int[] numbers, int left, int right) {

        int i = left, j = right, mid = (left + right) >> 1;
        while (i <= j) {

//            数字转换成字符串
            while ((numbers[i] + "" + numbers[mid]).compareTo(numbers[mid] + "" + numbers[i]) < 0) {
                i++;
            }
            while ((numbers[j] + "" + numbers[mid]).compareTo(numbers[mid] + "" + numbers[j]) > 0) {
                j--;
            }
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                //必不可少 防止出现i,j上的数和mid上的数相等的情况而陷入死循环
                j--;
                i++;
            }
        }

//        不加if判断在左右两端点时会栈溢出
        if (left < j) {
            numbers = QuickSort(numbers, left, j);
        }
        if (right > i) {
            numbers = QuickSort(numbers, i, right);
        }

        return numbers;
    }


    //    lambda表达式
    public static String PrintMinNumber2(int[] numbers) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i : numbers) {
            arrayList.add(i + "");
        }

        Collections.sort(arrayList, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));

        String result = "";
        for (String str : arrayList) {
            result += str;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{3, 5, 1, 4, 2};

        System.out.println(PrintMinNumber(numbers));
    }
}
