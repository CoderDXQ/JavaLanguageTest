package com.example.writtenexaminationandinterview.meituan;


import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 3:48 下午
 */
public class t1 {

    public static String huiwen(String st) {
        String result = "aa";

        char[] chs = st.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            char temp = chs[i];
            for (int j = 0; j < 10; j++) {
                chs[i] = fanhui(j);

//                这个生成方式生成的第一个是不是最小的
                String test = new String(chs);
                if (check(test)) {
//                    第一次
                    if (result.equals("aa")) {
                        result = test;
                    } else {
                        int a1 = Integer.valueOf(result);
                        int a2 = Integer.valueOf(test);
                        int minn = Math.min(a1, a2);
                        result = String.valueOf(minn);
                        for (int ii = result.length(); ii < st.length(); ii++) {
                            result = "0" + result;
                        }
                    }
                }
            }
//            回溯
            chs[i] = temp;
        }
        return result;
    }

    public static char fanhui(int i) {
        if (i == 0) {
            return '0';
        }
        if (i == 1) {
            return '1';
        }
        if (i == 2) {
            return '2';
        }
        if (i == 3) {
            return '3';
        }
        if (i == 4) {
            return '4';
        }
        if (i == 5) {
            return '5';
        }
        if (i == 6) {
            return '6';
        }
        if (i == 7) {
            return '7';
        }
        if (i == 8) {
            return '8';
        }
        if (i == 9) {
            return '9';
        }
        return 'a';
    }

    public static boolean check(String st) {
        if (st.length() == 1) {
            return true;
        }
        char[] chs = st.toCharArray();
        int mid = chs.length >> 1;
//        奇数
        if (chs.length % 2 == 1) {
            int i = mid - 1;
            int j = mid + 1;
            while (i >= 0 && j < chs.length) {
                if (chs[i] != chs[j]) {
                    return false;
                }
                i--;
                j++;
            }
        } else {
//            偶数
            int i = mid - 1;
            int j = mid;
            while (i >= 0 && j < chs.length) {
                if (chs[i] != chs[j]) {
                    return false;
                }
                i--;
                j++;
            }
        }
        return true;
    }

    //    注意是替换
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t > 0) {

            int n = in.nextInt();
            in.nextLine();
            String st = in.nextLine();
//            System.out.println(st);

            char[] chs = st.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != '0') {
                    chs[i] = '0';
                    break;
                }
            }

//            得到最小的串
            String minString = new String(chs);
            String hui = huiwen(st);
            if (hui.equals("aa")) {
                System.out.println(minString);
            } else {
                System.out.println(hui);
            }

            t--;
        }

    }


}
