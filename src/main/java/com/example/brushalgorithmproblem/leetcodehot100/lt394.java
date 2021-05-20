package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 12:19 上午
 */
//字符串解码
public class lt394 {

    public static int ptr;

    //    链表模拟 也可以用栈来模拟
    public static String decodeString(String s) {

        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
//                获得一个数字
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
//                获得一个字母 '['在stk中作分隔的作用
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
//                ']'的情况
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
//                顺便进行了翻转
                while (!"[".equals(stk.peekLast())) {
                    sub.addFirst(stk.removeLast());
                }

//                '['弹出
                stk.removeLast();

//                得到[]前的数字 也就是循环次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
//                将弹出的字符集合转换为字符串
                String o = getString(sub);

//                构造新的字符串
                while (repTime-- > 0) {
                    t.append(o);
                }

//                新串放进stk
                stk.addLast(t.toString());

            }
        }
        return getString(stk);
    }

    public static String getDigits(String s) {

        StringBuffer ret = new StringBuffer();
//        将ptr设置为全局变量就不再需要再来回传
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }

        return ret.toString();

    }

    public static String getString(LinkedList<String> v) {

        StringBuffer ret = new StringBuffer();

        for (String s : v) {
            ret.append(s);
        }

        return ret.toString();
    }

    public static String src;

    //    递归
    public static String decodeString1(String s) {
        src = s;
        ptr = 0;
        return dfs();
    }

    //    应该传入的变量都被设置成了全局变量了
    public static String dfs() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
//            获取数字
            repTime = getDigits1();
            ptr++;//过滤左括号
//            获取字符串
            String str = dfs();
            ++ptr;
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + dfs();
    }

    public static int getDigits1() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }


    //    双辅助栈
    public static String decodeString2(String s) {

        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
//                获得了当前的完整数字
                stack_multi.addLast(multi);
                multi = 0;
//                将上一个获取的字符串加进去
                stack_res.addLast(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
//                处理栈的内容 主要是字符串扩展
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
//                while (cur_multi-->0){
//                    tmp.append(res);
//                }
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
//                与之前的字符串组装
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
//                处理数字
//                将字符转换为字符串的技巧
                multi = multi * 10 + Integer.valueOf(c + "");
            } else {
//                处理字母
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";
        String s3 = "abc3[cd]xyz";

//        aaabcbc
        System.out.println(decodeString(s));
//        accaccacc
        System.out.println(decodeString(s1));
//        abcabccdcdcdef
        System.out.println(decodeString(s2));
//        abccdcdcdxyz
        System.out.println(decodeString(s3));

        System.out.println();

        System.out.println(decodeString1(s));
        System.out.println(decodeString1(s1));
        System.out.println(decodeString1(s2));
        System.out.println(decodeString1(s3));

        System.out.println();

//        aaabcbc
        System.out.println(decodeString2(s));
//        accaccacc
        System.out.println(decodeString2(s1));
//        abcabccdcdcdef
        System.out.println(decodeString2(s2));
//        abccdcdcdxyz
        System.out.println(decodeString2(s3));

    }

}
