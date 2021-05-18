package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/18 10:50 下午
 */
public class lt76 {

    //    滑动窗口
    public static String minWindow(String s, String t) {

        int left = 0, right = t.length();
        String res = "";

        while (right <= s.length()) {

            String sub = s.substring(left, right);

            while (check(sub, t)) {

                if (res == "" || sub.length() < res.length()) {
                    res = sub;
                }
//                左边界缩减
                left++;
                if (left < right) {
                    sub = s.substring(left, right);
                } else {
                    break;
                }
            }

//            右边界扩充
            right++;

        }

        return res;
    }


    //    这种判断会超时 时间复杂度有点高
    public static boolean check(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        int i = 0, k = 0;

        while (k < t1.length && i < s1.length) {

            while ((k < s1.length && i < s1.length) && (t1[k] != s1[i])) {
                i++;
            }
//            存在重复的情况
            if ((k < t1.length && i < s1.length) && (t1[k] == s1[i])) {
                k++;
                i++;
            }

        }

//        巧妙的判断条件
        return k == t1.length ? true : false;

    }

    public static Map<Character, Integer> ori;
    public static Map<Character, Integer> cnt;

    //    滑动窗口 使用map技术
    public static String minWindow1(String s, String t) {

        ori = new HashMap<>();
        cnt = new HashMap<>();

        int tLen = t.length();

        char[] chs = t.toCharArray();
        char[] ss = s.toCharArray();

//        统计目标串的数据
        for (char ch : chs) {
            ori.put(ch, ori.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();

        while (r < sLen) {
//            右边界右移
            r++;
//            计数map更新
            if (r < sLen && ori.containsKey(ss[r])) {
                cnt.put(ss[r], cnt.getOrDefault(ss[r], 0) + 1);
            }
            while (check1() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = r + 1;
                }
//                左边界右移  寻找更优结果
                if (ori.containsKey(ss[l])) {
                    cnt.put(ss[l], cnt.getOrDefault(ss[l], 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static boolean check1() {

        Iterator iter = ori.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
//            子串对目标串的某个字符数目不足
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

//        System.out.println(check(s1, t1));
//
//        System.out.println(check(s2, t2));
//
//        System.out.println();


        System.out.println(minWindow(s1, t1));
        System.out.println(minWindow(s2, t2));

        System.out.println();

        System.out.println(minWindow1(s1, t1));
        System.out.println(minWindow1(s2, t2));

    }

}
