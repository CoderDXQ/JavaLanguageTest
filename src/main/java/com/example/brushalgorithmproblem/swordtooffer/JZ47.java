package com.example.brushalgorithmproblem.swordtooffer;

import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/30 1:40 上午
 */
//求1+2+3+...+n
public class JZ47 {

    public int Sum_Solution(int n) {

        return ((1 + n) * n) >> 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        JZ47 solution = new JZ47();
        System.out.println(solution.Sum_Solution(in.nextInt()));
    }
}
