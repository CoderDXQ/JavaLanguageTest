package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/22 11:27 下午
 */
//无重复字符的最长子串
public class lt3 {

    //    滑动窗口 遍历窗口左侧起始点
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;

        int right = -1;
        int ans = 0;
//        标记某个元素是否重复
        HashMap<Character, Integer> hashMap = new HashMap<>();
//        遍历起始点
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                hashMap.remove(s.charAt(left - 1));
                ans--;
            }
            while (right + 1 < s.length() && !hashMap.containsKey(s.charAt(right + 1))) {
                right++;
                ans++;
                hashMap.put(s.charAt(right), 1);
            }
            result = Math.max(result, ans);
        }
        return result;
    }

    //    滑动窗口 遍历右侧终止点
    public static int lengthOfLongestSubstring1(String s) {

        int result = 0;

//        存放每个字符最后出现的位置的后一个位置
        HashMap<Character, Integer> hashMap = new HashMap<>();
//        从左到右遍历右侧终止点
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (hashMap.containsKey(s.charAt(end))) {
//                找到新的滑动窗口的起始位置
                start = Math.max(hashMap.get(s.charAt(end)), start);
            }
//            记录某个字符出现的最后位置的后一个位置  这个方法可以覆盖
            hashMap.put(s.charAt(end), end + 1);
//            计算最新的滑动窗口大小
            result = Math.max(result, end - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));

    }

}
