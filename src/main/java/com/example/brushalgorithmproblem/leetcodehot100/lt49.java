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

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(strs).forEach(a -> {
            a.forEach(b -> {
                System.out.print(b + " ");
            });
            System.out.println();
        });
    }

}
