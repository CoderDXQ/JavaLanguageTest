package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/4 9:05 下午
 */
public class JZ51 {


    public static int[] multiply(int[] A) {
        int[] result = new int[A.length];

        int[] left=new int[A.length];
        int[] right=new int[A.length];

        left[0]=1;
        right[A.length-1]=1;
        right[0]=1;
        for(int i=1;i<A.length;i++){
            left[i]=A[i-1]*left[i-1];
            right[A.length-i-1]=A[A.length-i]*right[A.length-i];
        }
        for(int i=0;i<A.length;i++){
            result[i]=left[i]*right[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 3, 4, 5};

        int[] result = multiply(A);

        for (int a : result) {
            System.out.println(a + " ");
        }

    }
}
