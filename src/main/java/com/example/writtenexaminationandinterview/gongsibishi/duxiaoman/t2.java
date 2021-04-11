package com.example.writtenexaminationandinterview.gongsibishi.duxiaoman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 1.找到所有字母的种类
 * 2.每个位置替换一遍所有的字母
 * 3.对所有的结果进行统计
 *
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/11 4:12 下午
 */
public class t2 {

    public static int result;
    public static Set<Character> set = new HashSet<>();

    public static void tongji(String string) {

        char[] chs = string.toCharArray();
        int k = 0;
        int max = 0;
        char flag = chs[0];
        for (char c : chs) {
            if (c == flag) {
                k++;
            } else {
                max = Math.max(max, k);
                flag = c;
                k = 1;
            }
        }

        max = Math.max(max, k);

        result = Math.max(max, result);
    }


//    String stest = s.substring(0, i) + c + s.substring(i + 1, s.length());

    public static void dfs(String str, int k, int index, int jishu) {

        if (jishu == k) {
            tongji(str);
            return;
        }

        tongji(str);


        for (int i = index; i < str.length(); i++) {
            jishu++;
            for (char c : set) {
                String stest = str.substring(0, i) + c + str.substring(i + 1, str.length());
                dfs(stest, k, i + 1, jishu);
            }
            jishu--;
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

//        吸收掉多余的换行符
        in.nextLine();

        String s = in.nextLine();

        result = 0;


        char[] chs = s.toCharArray();

        for (Character c : chs) {
            set.add(c);
        }

        dfs(s, k, 0, 0);

        System.out.println(result);
    }

}
