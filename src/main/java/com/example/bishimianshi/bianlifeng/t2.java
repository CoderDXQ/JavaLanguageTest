package com.example.bishimianshi.bianlifeng;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/20 3:23 下午
 */
public class t2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] daoda = new int[n];
        int[] haoshi = new int[n];
        for (int i = 0; i < n; i++) {
            String st = in.next();
            int location = st.indexOf(',');
            daoda[i] = Integer.valueOf(st.substring(0, location));
            haoshi[i] = Integer.valueOf(st.substring(location + 1, st.length()));
        }

        int start = 0;
        int end = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (end < daoda[i]) {
                start=daoda[i];
            }else if(end>=daoda[i]){
                start=end;
            }
            end=start+haoshi[i];
            sum+=end-daoda[i];
        }

        System.out.println(sum);
    }
}
