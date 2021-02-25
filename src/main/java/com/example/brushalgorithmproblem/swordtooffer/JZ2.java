package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/13 10:27 下午
 */
public class JZ2 {
    public static void main(String[] args) {
        JZ2 solution = new JZ2();
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(solution.replaceSpace(str));
        System.out.println(solution.replaceSpace1(str));
        System.out.println(solution.replaceSpace("We Are Happy"));
    }

    public String replaceSpace(String s) {
        String st = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                st += s.charAt(i);
            } else {
                st += "%20";
            }
        }
        return st;
    }

    public String replaceSpace(StringBuffer str) {
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b = str.charAt(i);
            if (!String.valueOf(b).equals(" ")) {
                st.append(b);
            } else {
                st.append("%20");
            }
        }
        return st.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                out.append("%20");
            } else {
                out.append(str.charAt(i));
            }
        }
        return out.toString();

    }
}
