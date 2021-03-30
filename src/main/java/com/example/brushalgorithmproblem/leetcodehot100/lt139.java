package com.example.brushalgorithmproblem.leetcodehot100;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:30 上午
 */
public class lt139 {

    public static boolean wordBreak(String s, List<String> wordDict) {


        return true;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        String[] a = new String[]{"leet", "code"};
        List<String> wordDict1 = new ArrayList<String>();
        for (String ss : a) {
            wordDict1.add(ss);
        }
        System.out.println(wordBreak(s, wordDict1));

    }

}
