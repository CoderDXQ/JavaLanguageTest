package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/4 4:25 下午
 */
//字符串的排列
public class JZ27 {

    //    TreeSet可以自动去重和排序
    public static TreeSet<String> result = new TreeSet<>();

    //    DFS回溯
    public static ArrayList<String> Permutation(String str) {

//        初始化
        result.clear();

        permulaiton(str, 0);

        ArrayList<String> res = new ArrayList<>();
        res.addAll(result);

        return res;
    }

    public static void permulaiton(String str, int pos) {

        if (pos == str.length() - 1) {
            System.out.println("str=" + str + " pos=" + pos + " length-1=" + (str.length() - 1));
            result.add(str);
            return;
        }

        for (int i = pos; i < str.length(); i++) {

            System.out.println("str=" + str + " pos=" + pos + " i=" + i + " " + swap(str, pos, i));
//            不需要手动回溯了
            permulaiton(swap(str, pos, i), pos + 1);
        }

    }

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();

        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;

        str = "";
        for (int ii = 0; ii < ch.length; ii++) {
            str += ch[ii];
        }

        return str;
    }

    public static void main(String[] args) {
        String str = "cba";

//        System.out.println(swap(str,0,1));

        ArrayList<String> ss = Permutation(str);
        for (String s : ss) {
            System.out.println(s);
        }
    }
}
