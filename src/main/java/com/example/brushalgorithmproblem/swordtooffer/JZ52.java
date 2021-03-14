package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/12 11:48 下午
 */
public class JZ52 {

    //    根据测试用例加规则  这种方式太麻烦了 还没有成功
    public static boolean match(String str, String pattern) {

//        万能匹配
        if (pattern.startsWith(".*")) {
            return true;
        }

        if (str.length() == 0 && pattern.length() == 1 && pattern.charAt(0) == '*') {
            return true;
        }
        if (str.length() == 0 && pattern.length() == 1 && pattern.charAt(0) == '.') {
            return false;
        }

//        注意这个if和下面的if的前后关系
        if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (str.length() != 0 && pattern.length() == 0) {
            return false;
        }

        if (str.length() == 0 && pattern.charAt(1) == '*') {
            return true;
        }

        if (str.length() == 1 && pattern.charAt(0) == 1) {
            return true;
        }

        int i = 0, j = 0;

//        两个串都没有到头
        while (i <= str.length() - 1 && j <= pattern.length() - 1) {

//            匹配"."
            if (pattern.charAt(j) == '.') {
                i++;
                j++;
                continue;
            }

            if (str.charAt(i) == pattern.charAt(j) && i == str.length() - 1) {
                return true;
            }

            if (str.charAt(i) == pattern.charAt(j) && j < pattern.length() - 1 && pattern.charAt(j + 1) != '*') {
                i++;
                j++;
                continue;
            }

//            匹配串不够长
            if (str.charAt(i) == pattern.charAt(j) && i < str.length() - 1 && j == pattern.length() - 1) {
                return false;
            }
//            匹配"*"
            if (i < str.length() && j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                while (str.charAt(i) == pattern.charAt(j)) {
                    i++;
                }
                j++;
                j++;
                continue;
            }

//            单纯的字符不相等 没有通配符
            if (str.charAt(i) != pattern.charAt(j) && pattern.charAt(j) != '.' && j < pattern.length() - 1 && pattern.charAt(j + 1) != '*') {
                return false;
            }
        }

        if (i == str.length() - 1 && str.charAt(i) == pattern.charAt(j)) {
            return true;
        }
//        两个串有一个没有用完  则不匹配
        if (i != str.length() - 1 || j != pattern.length() - 1) {
            return false;
        }
        return true;
    }

    //    抽象成递归方法  这种题目最重要的就是要逻辑清晰
    public static boolean match1(String str, String pattern) {
        char[] strings = str.toCharArray();
        char[] patterns = pattern.toCharArray();

        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(strings, strIndex, patterns, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        // pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 模式下一位是*，且字符串当前位跟模式当前位匹配,分3种匹配模式；如不匹配，模式后移2位
        // 模式下一位为'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 字符串当前位与模式当前位匹配
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                // 模式后移2，视为x*匹配0个字符
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        // 视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        // *匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
                // 字符串当前位与模式当前位不匹配
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        // 模式下一位不是*，且字符串当前位跟模式当前位匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    //    动态规划 时间复杂度有点高  并不是很推荐
    public static boolean match2(String str, String pattern) {
        int s = str.length();
        int p = pattern.length();
        boolean[][] dp = new boolean[s + 1][p + 1];//存放匹配结果 dp[i][j]用于存放模式串前j个是否与字符串前i个匹配 初始值是false
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= p; j++) {
                if (j == 0) {//i=0 j=0 说明模式串和匹配串都为空 此时是true
                    dp[i][j] = (i == 0);
                } else {
                    if (pattern.charAt(j - 1) != '*') {
//                        字符相等和模式串中"."的情况
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
//                            正常匹配 继承之前的值
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
//                        模式串中"*"的情况 匹配0个
                        if (j >= 2) {
                            dp[i][j] = dp[i][j - 2];
                        }
                        if (i > 0 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
//                            在匹配0个和匹配多个之间取并
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
//                打印分析
                printdp(dp);
                System.out.println();
            }
        }
        return dp[str.length()][pattern.length()];
    }

    public static void printdp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String str = "aaa", pattern = "ab*ac*a";
//        true
        System.out.println(match(str, pattern));
        System.out.println();

        System.out.println(match1(str, pattern));
        System.out.println();

        System.out.println(match2(str, pattern));
        System.out.println();

    }
}
