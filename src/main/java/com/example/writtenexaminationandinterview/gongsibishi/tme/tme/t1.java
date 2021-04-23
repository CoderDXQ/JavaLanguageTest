package com.example.writtenexaminationandinterview.gongsibishi.tme.tme;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/23 2:35 下午
 */
public class t1 {


    public static String reverse(String str) {

        String[] s = str.split(" ");
        String result = "";
        for (int i = s.length - 1; i >= 0; i--) {
            result += s[i];
            if (i != 0) {
                result += " ";
            }
        }

//        System.out.println(result);

        return result;

    }

    public static Queue<String> queue;

//    public static void print(String str) {
//
//        queue = new LinkedList<>();
//        for (int i = 0; i < str.length(); i++) {
//            queue.add(str.substring(i, i + 1));
//        }
//        bfs(str);
//
//    }

    //    ???
    public static void bfs(String str) {

        while (queue.size() != 0) {
            String s = queue.poll();
            System.out.println(s);
            int index = str.indexOf(s);
            int len = s.length();

            for (int i = index + len; i < str.length(); i++) {
                queue.offer(s + str.substring(i, i + 1));
            }

        }

    }

    public static void print(String str) {
        dfs(str, 0, "");
    }

    public static void dfs(String str, int index, String s) {

        for (int i = index; i < str.length(); i++) {
            String ss = s;
            ss += str.substring(i, i + 1);
            System.out.println(ss);
            dfs(str, i + 1, ss);
        }

    }

//    public static void print(String str) {
//
//        for (int i = 1; i <= 26; i++) {
//            for (int j = 0; j < 26; j++) {
//                if (j + i <= 26) {
//                    System.out.println(str.substring(j, j + i));
//                }
//            }
//        }
//
//    }

    public static ArrayList<Integer> union(int[] array1, int[] array2) {

        Set<Integer> c = new HashSet<>();

        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array1[j]) {
                c.add(array1[i]);
                i++;
            } else {
                c.add(array2[j]);
                j++;
            }
        }

        while (i < array1.length) {
            c.add(array1[i++]);
        }

        while (j < array2.length) {
            c.add(array2[j++]);
        }

        ArrayList<Integer> result = new ArrayList<>(c);

        return result;
    }

    public static void main(String[] args) {

        String chs = "i am on duty today";

        reverse(chs);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        print(str);


        int[] array1 = new int[]{1, 2, 3, 3, 4};
        int[] array2 = new int[]{2, 3, 4, 5, 6};

        union(array1, array2);

    }


}