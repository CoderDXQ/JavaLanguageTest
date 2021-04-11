package com.example.writtenexaminationandinterview.gongsibishi.wangyi;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 2:57 下午
 */
public class t3 {

    public static int canCompleteRace(int[] e, int[] c) {
        // write code here

        int len = e.length;

        int[] use = new int[len];
        for (int i = 0; i < len; i++) {
            use[i] = e[i] - c[i];
        }

        for (int i = 0; i < len; i++) {
            int remain = 0;
            for (int j = i; j < i + len; j++) {
                int index = j >= len ? j - len : j;
                remain += use[index];
                if (remain < 0) {
                    break;
                }
            }
            if (remain >= 0) {
                return i;
            }
        }


        return -1;
    }


    public static void main(String[] args) {

        //[1,2,3,4,5],[3,4,5,1,2]
        int[] e = new int[]{1, 2, 3, 4, 5};
        int[] c = new int[]{3, 4, 5, 1, 2};

        System.out.println(canCompleteRace(e, c));


    }

}
