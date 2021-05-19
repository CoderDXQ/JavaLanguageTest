package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.*;

/**
 * @author duanxiangqing
 * @date 2021/5/17
 */
//删除无效的括号
public class lt301 {

//    还可以通过删除或者添加来构造所有的情况 然后将这些情况去重并检验合法性

    public static int len;
    public static char[] charArray;
    public static Set<String> validExpressions;

    //    回溯搜索DFS
    public static List<String> removeInvalidParentheses(String s) {

//        初始化
        len = s.length();
        charArray = s.toCharArray();
//        去重
        validExpressions = new HashSet<>();

//        统计左右括号的情况
        int leftRemove = 0, rightRemove = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                leftRemove++;
            } else if (charArray[i] == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }

        StringBuilder path = new StringBuilder();

        dfs(0, 0, 0, leftRemove, rightRemove, path);

        return new ArrayList<>(validExpressions);
    }

    /**
     * @param index       当前遍历到的字符串的下标
     * @param leftCount   已经使用的左括号个数 剪枝用的
     * @param rightCount  已经使用的右括号个数 剪枝用的
     * @param leftRemove  最少应该删除的左括号个数
     * @param rightRemove 最少应该删除的右括号个数
     * @param path        被组装的结果
     */
    //    在遍历字符串的过程中决定是否删除当前字符来实现搜索
    public static void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder path) {

        if (index == len) {
//            需要删除的左右括号都为0
            if (leftRemove == 0 && rightRemove == 0) {
                validExpressions.add(path.toString());
            }
            return;
        }

        char ch = charArray[index];

//        删除当前遍历遇到的字符
        if (ch == '(' && leftRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
        }
        if (ch == ')' && rightRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
        }

//        保留当前字符 可能是括号也可能不是括号
        path.append(ch);
//        非括号
        if (ch != '(' && ch != ')') {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove, path);
        } else if (ch == '(') {
//            左括号
            dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
        } else if (rightCount < leftCount) {//这算是一个补充条件 右括号的数目是不能比左括号多的 在这里用来剪枝了
//            右括号
            dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
        }

//        回溯 递归回退的时候不影响结果
        path.deleteCharAt(path.length() - 1);

    }

    //    BFS
    public static List<String> removeInvalidParentheses1(String s) {

        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        Set<String> visited = new HashSet<>();
        visited.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String front = queue.poll();
                if (isValid(front)) {
                    res.add(front);
                    found = true;
                }

                int curLen = front.length();
                char[] chs = front.toCharArray();

                for (int j = 0; j < curLen; j++) {
                    if (front.charAt(j) != '(' && front.charAt(j) != ')') {
                        continue;
                    }

//                    截取新的结果
//                    new String()方法的API，第一个参数是字符数组，第二个参数是起始下标，第三个参数是截取的字符串长度
                    String next = new String(chs, 0, j) + new String(chs, j + 1, curLen - j - 1);
//                    判重
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }

            }
//            这一层找到以后就不再继续寻找了 因为题目要求找的就是删除最少的  再往下找还要继续删除
//            剪枝
            if (found) {
                break;
            }
        }
        return res;
    }

    public static boolean isValid(String s) {

        char[] chs = s.toCharArray();
        int count = 0;
        for (char ch : chs) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
//            右括号一旦多于左括号那么就是非法的
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }


    public static void main(String[] args) {

        String s1 = "()())()";
        String s2 = "(a)())()";
        String s3 = ")(";
        String s4 = "()())()";
        String s5 = "(a)())()";
        String s6 = ")(";

//        "()()()", "(())()"
        System.out.println(removeInvalidParentheses(s1));
//        "(a)()()", "(a())()"
        System.out.println(removeInvalidParentheses(s2));
//        ""
        System.out.println(removeInvalidParentheses(s3));
//        "(())()","()()()"
        System.out.println(removeInvalidParentheses(s4));
//        "(a())()","(a)()()"
        System.out.println(removeInvalidParentheses(s5));
//        ""
        System.out.println(removeInvalidParentheses(s6));

        System.out.println();

        //        "()()()", "(())()"
        System.out.println(removeInvalidParentheses1(s1));
//        "(a)()()", "(a())()"
        System.out.println(removeInvalidParentheses1(s2));
//        ""
        System.out.println(removeInvalidParentheses1(s3));
//        "(())()","()()()"
        System.out.println(removeInvalidParentheses1(s4));
//        "(a())()","(a)()()"
        System.out.println(removeInvalidParentheses1(s5));
//        ""
        System.out.println(removeInvalidParentheses1(s6));

    }

}
