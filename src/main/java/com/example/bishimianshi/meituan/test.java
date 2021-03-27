package com.example.bishimianshi.meituan;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 5:35 下午
 */
public class test {
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

    public static void main(String[] args) {
        System.out.println(check("01011"));

    }

}
