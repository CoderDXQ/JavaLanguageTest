package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 3:09 下午
 */

//字母异位词分组
public class lt49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            Character[] chs = new Character[strs[i].length()];
            for (int j = 0; j < chs.length; j++) {
                chs[j] = strs[i].charAt(j);
            }

            Arrays.sort(chs);
            String newS = "";
            for (int j = 0; j < chs.length; j++) {
                newS += chs[j];
            }
//            System.out.println(newS);

            if (hashMap.containsKey(newS)) {
                List<String> l = hashMap.get(newS);
                l.add(strs[i]);
                hashMap.replace(newS, l);

            } else {
                List<String> ll = new LinkedList<>();
                ll.add(strs[i]);
                hashMap.put(newS, ll);
            }
        }

        List<List<String>> result = new LinkedList<>();

        for (String st : hashMap.keySet()) {
            result.add(hashMap.get(st));
        }

        return result;
    }

    //    重写上面的方法
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String st = new String(chs);
//            如果有就拿到  如果没有就用括号里的参数，这就是设置的默认情况
            List<String> list = hashMap.getOrDefault(st, new ArrayList<String>());
            list.add(str);
//            put方法会覆盖
            hashMap.put(st, list);
        }
//        values()方法直接拿到hashMap的所有值
        return new ArrayList<List<String>>(hashMap.values());
    }


    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(strs).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
        System.out.println();
        groupAnagrams1(strs).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
    }

}
