package com.example.writtenexaminationandinterview.wangyi;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 2:53 下午
 */
public class t1 {

    public static int billsChange(int[] bills) {
        // write code here

        int k5 = 2;
        int k10 = 0;
        int res = 0;

        for (int i : bills) {
            if (i == 5) {
                k5++;
                res++;
            } else if (i == 10) {
                if (k5 > 0) {
                    k10++;
                    k5--;
                    res++;
                } else {
                    break;
                }
            } else {
                int need = i - 5;
                while (need >= 10 && k10 > 0) {
                    k10--;
                    need -= 10;
                }

                while (need >= 5 && k5 > 0) {
                    k5--;
                    need -= 5;
                }

                if (need == 0) {
                    res++;
                } else {
                    break;
                }


            }

        }

        return res;


    }


    public static void main(String[] args) {

        int[] bills = new int[]{5, 5, 5, 5, 20, 20, 20};

        System.out.println(billsChange(bills));

    }

}
