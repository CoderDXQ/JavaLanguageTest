package com.example.brushalgorithmproblem.leetcodehot100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/17 11:49 下午
 */

//括号生成
public class lt22 {

    public static List<String> result;

    //    DFS搜索 回溯
    public static List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        ArrayList<Character> str = new ArrayList<>();
        dfs(n, str);
        return result;
    }

    public static void dfs(int n, ArrayList<Character> str) {
        if (str.size() == 2 * n) {
            if (isvalid(str)) {
                result.add(trans(str));
            }
            return;
        }

        str.add('(');
        dfs(n, str);
        str.remove(str.size() - 1);

        str.add(')');
        dfs(n, str);
        str.remove(str.size() - 1);
    }

    public static boolean isvalid(ArrayList<Character> str) {

        int sum = 0;
        for (Character c : str) {
            if (c == '(') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }

        return sum == 0 ? true : false;
    }

    public static String trans(ArrayList<Character> str) {
        String result = "";
        for (Character c : str) {
            result += c;
        }
        return result;
    }


    //    记录长度为n时的结果集
    public static ArrayList[] cache = new ArrayList[100];

    //    动态规划 ？？？需要再理解理解
    public static List<String> generateParenthesis1(int n) {
        return generate1(n);
    }

    public static List<String> generate1(int n) {
//        剪枝 缓存当n不同值时的结果  最终cache[n]=generate1(n)
        if (cache[n] != null) {
            return cache[n];
        }

        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
//            从0递推到n
            for (int c = 0; c < n; c++) {
                for (String left : generate1(c)) {
                    for (String right : generate1(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
//        到这里 此时n的值的计算结束  存储一下
        cache[n] = ans;
        return ans;
    }


    //    生成策略 剩下的左括号与右括号数值相等时，必须先添加左括号
    public static List<String> generateParenthesis2(int n) {
        result = new LinkedList<>();

        generate("", n, n);

        return result;
    }

    public static void generate(String string, int left, int right) {

        if (left == 0 && right == 0) {
            result.add(string);
        }

        if (left == right) {
            generate(string + "(", left - 1, right);
        } else {
            if (left > 0) {
                generate(string + "(", left - 1, right);
            }

            if (right > 0) {
                generate(string + ")", left, right - 1);
            }
        }
    }


    public static void main(String[] args) {
        int n = 3;

        generateParenthesis(n).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        generateParenthesis1(n).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        generateParenthesis2(n).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

    }
}
