package com.example.bishimianshi.meituan;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:51 下午
 */
public class t2 {

    public static void main(String[] args) {
        long n, c1, c2;
        String st;
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        c1 = in.nextLong();
        c2 = in.nextLong();
//        吸收换行符
        in.nextLine();
        st = in.nextLine();

//        System.out.println(n + " " + c1 + " " + c2);
//        System.out.println(st);

        if (n == 0 || c1 == 0 || c2 == 0) {
            System.out.println(0);
            in.nextLine();
            return;
        }

        long minc = Math.min(c1, c2);
        long numOfF = 0;
        long numOfSkill = 0;
        char[] chs = st.toCharArray();
        for (char ch : chs) {
            if (ch == 'F') {
                numOfF++;
            }
            if (numOfF == 3) {
                numOfF = 0;
                numOfSkill++;
            }

        }
        System.out.println(numOfSkill * minc);

    }


}
