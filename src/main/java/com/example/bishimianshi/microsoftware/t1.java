package com.example.bishimianshi.microsoftware;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/28 2:19 下午
 */
public class t1 {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;

        int sum = 0;
        for (int i : A) {
            if (i < 0) {
                result = Math.max(result, sum);
                sum = 0;
            } else {
                sum += i;
            }
        }

        result = Math.max(result, sum);
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1,-2,0};
        System.out.println(solution(A));

    }
}
