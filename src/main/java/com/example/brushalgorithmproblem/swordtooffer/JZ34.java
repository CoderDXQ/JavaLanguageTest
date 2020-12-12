package com.example.brushalgorithmproblem.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/12 4:53 下午
 */
public class JZ34 {
    public static void main(String[] args) {
        String str = "google";
        int out;
        JZ34 s1 = new JZ34();
        // out = s1.FirstNotRepeatingChar1(str);
        out = s1.FirstNotRepeatingChar2(str);
        System.out.println(out);
    }


    public int FirstNotRepeatingChar2(String str) {
        int[] array = new int[10005];
        char ss[] = str.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            array[ss[i] - 'A']++;
        }
        for (int i = 0; i < ss.length; i++) {
            if (array[ss[i] - 'A'] == 1) return i;
        }
        return -1;
    }
}
