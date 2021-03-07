package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/4 7:24 下午
 */
public class JZ67 {

    //    数学抽象
    public static int cutRope1(int target) {
        if (target <= 3) {
            return target;
        }
        int result = 1;

        int yu = target % 3;
        int shang = target / 3;

//        System.out.println("yu=" + yu + "shang=" + shang);

        if (yu == 0) {
            result = (int) Math.pow(3, shang);
        } else if (yu == 1) {
//            退一个3变成两个2
            result = (int) Math.pow(3, shang - 1) * 4;

        } else if (yu == 2) {
            result = (int) Math.pow(3, shang) * 2;
        }


        return result;
    }

    public static int[] rem = new int[100000];


    //    记忆化搜索
    public static int cutRope(int target) {

        rem[2] = 2;
        rem[3] = 3;

        if (target == 2) {
            return 2;
        }
        if (target == 3) {
            return 3;
        }

//        for (int i = 2; i < target; i++) {
//            rem[target] = Math.max(rem[target], rem[i] * cutRope(target - i));
//        }

        for (int i = target; i >= 3; i--) {
            rem[target] = Math.max(rem[target], rem[i] * cutRope(target - i));
        }

        return rem[target];
    }


    public static void main(String[] args) {

        int n = 8;
        System.out.println(cutRope(n));

    }
}
