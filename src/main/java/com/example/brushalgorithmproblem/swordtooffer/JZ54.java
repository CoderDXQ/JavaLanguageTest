package com.example.brushalgorithmproblem.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 5:51 下午
 */
//字符流中第一个不重复的字符
//字符流输入时，每读入一个字符调用一次Insert方法，在想输出结果的时刻调用一下FirstAppearingOnce方法
public class JZ54 {

    public static int[] chs = new int[128];
    public static Queue<Character> queue = new LinkedList<Character>();

    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (chs[ch] == 0) {
//            只要是头一次出现就添加到队列
            queue.add(ch);
        }
        chs[ch]++;
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        char result = '#';
        while (!queue.isEmpty()) {
            char t = queue.peek();
//            只出现过一次
            if (chs[t] == 1) {
                result = t;
                break;
            } else {
//                出现过多次就删除
                queue.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "google";
        for (int i = 0; i < str.length(); i++) {
            Insert(str.charAt(i));
        }
        System.out.println(FirstAppearingOnce());

    }
}
