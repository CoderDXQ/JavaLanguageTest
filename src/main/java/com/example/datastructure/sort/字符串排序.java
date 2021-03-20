package com.example.datastructure.sort;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 3:05 下午
 */
public class 字符串排序 {

    public static void main(String[] args) {
        String[] input = new String[]{"tmc", "apad", "apache", "nihao", "nihaoa"};
        String[] keys = arraySort(input);
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public static String[] arraySort(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    String temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }

}
