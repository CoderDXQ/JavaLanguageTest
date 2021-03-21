package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 9:57 上午
 */
//电话号码的字母组合
public class lt17 {

    public static List<String> result;
    public static HashMap<Character, String[]> hashMap = new HashMap<>();

    //    dfs 回溯
    public static List<String> letterCombinations(String digits) {

//        初始化
        result = new LinkedList<>();

        if (digits.equals("")) {
            return result;
        }

        hashMap.put('2', new String[]{"a", "b", "c"});
        hashMap.put('3', new String[]{"d", "e", "f"});
        hashMap.put('4', new String[]{"g", "h", "i"});
        hashMap.put('5', new String[]{"j", "k", "l"});
        hashMap.put('6', new String[]{"m", "n", "o"});
        hashMap.put('7', new String[]{"p", "q", "r", "s"});
        hashMap.put('8', new String[]{"t", "u", "v"});
        hashMap.put('9', new String[]{"w", "x", "y", "z"});

        dfs(digits, 0, "");

        return result;
    }

    public static void dfs(String digits, int n, String ans) {

        if (n == digits.length()) {
            result.add(ans);
//            一定要设置返回条件
            return;
        }

        if (hashMap.containsKey(digits.charAt(n))) {
            for (String st : hashMap.get(digits.charAt(n))) {
//                直接写ans+st就不用再回溯了 因为这样的状态就是不保留的
                dfs(digits, n + 1, ans + st);
            }
        }

    }

    //   bfs 使用队列
    public static List<String> letterCombinations1(String digits) {

        result = new LinkedList<>();

        if (digits.equals("")) {
            return result;
        }

        hashMap.put('2', new String[]{"a", "b", "c"});
        hashMap.put('3', new String[]{"d", "e", "f"});
        hashMap.put('4', new String[]{"g", "h", "i"});
        hashMap.put('5', new String[]{"j", "k", "l"});
        hashMap.put('6', new String[]{"m", "n", "o"});
        hashMap.put('7', new String[]{"p", "q", "r", "s"});
        hashMap.put('8', new String[]{"t", "u", "v"});
        hashMap.put('9', new String[]{"w", "x", "y", "z"});

        Queue<String> queue = new LinkedList<>();

        int k = 0;
        if (hashMap.containsKey(digits.charAt(k))) {
            for (String st : hashMap.get(digits.charAt(k))) {
                queue.offer(st);
            }
            k++;
        }

//        bfs
        while (!queue.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }

            if (k == digits.length()) {
                return list;
            }

            if (hashMap.containsKey(digits.charAt(k))) {
                for (String s1 : list) {
                    for (String s2 : hashMap.get(digits.charAt(k))) {
                        queue.offer(s1 + s2);
                    }
                }
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";

        letterCombinations(digits).forEach(a -> {
            System.out.print(a + " ");
        });

        System.out.println();

        letterCombinations1(digits).forEach(a -> {
            System.out.print(a + " ");
        });

        System.out.println();
    }
}
