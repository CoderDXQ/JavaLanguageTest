package com.example.bishimianshi.bianlifeng;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 3:40 下午
 */
public class t3 {

    public static int result = 0;

    public static int dfs(String[][] table) {

        digui(table, 0, 0);

//        不可达
        return 0;
    }

    public static void digui(String[][] table, int i, int j) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inn = in.nextLine();
        String[] hang = inn.split(";");
        String[][] table = new String[hang.length][hang[0].length()];

        int k = 0;
        for (String st : hang) {
            String[] atom = st.split(",");
            table[k] = atom;
        }

        dfs(table);


//        System.out.println();

    }
}
