package com.example.writtenexaminationandinterview.gongsibishi.bianlifeng;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 3:40 下午
 */
public class t3 {

    public static int result = 1;

    public static int out = Integer.MAX_VALUE;

    public static int dfs(String[][] table) {
//        按照题意进行初始化
        result = 1;
        digui(table, 0, 0, result);
        return out;
    }

    //    回溯
    public static void digui(String[][] table, int i, int j, int result) {
        if (i == table.length - 1 && j == table[0].length - 1) {
            out = Math.min(out, result);
        }

        if (check(i + 1, table.length - 1) && check(j, table[0].length - 1) && table[i + 1][j].equals("1")) {
            table[i + 1][j] = "0";
            digui(table, i + 1, j, result + 1);
            table[i + 1][j] = "1";
        }
        if (check(i - 1, table.length - 1) && check(j, table[0].length - 1) && table[i - 1][j].equals("1")) {
            table[i - 1][j] = "0";
            digui(table, i - 1, j, result + 1);
            table[i - 1][j] = "1";
        }
        if (check(i, table.length - 1) && check(j + 1, table[0].length - 1) && table[i][j + 1].equals("1")) {
            table[i][j + 1] = "0";
            digui(table, i, j + 1, result + 1);
            table[i][j + 1] = "1";
        }
        if (check(i, table.length - 1) && check(j - 1, table[0].length - 1) && table[i][j - 1].equals("1")) {
            table[i][j - 1] = "0";
            digui(table, i, j - 1, result + 1);
            table[i][j - 1] = "1";
        }
    }

    public static boolean check(int i, int len) {
        return i >= 0 && i <= len;
    }

    public static void main(String[] args) {

//        1,0,1,1;1,1,1,1;1,1,0,1;0,0,0,1
        Scanner in = new Scanner(System.in);

        String inn = in.nextLine();
        String[] hang = inn.split(";");
        String[][] table = new String[hang.length][hang[0].length()];

        int k = 0;
        for (String st : hang) {
            String[] atom = st.split(",");
            table[k++] = atom;
        }

        System.out.println(dfs(table));

    }
}
