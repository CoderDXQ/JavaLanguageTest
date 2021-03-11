package com.example.brushalgorithmproblem.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 12:08 下午
 */
public class JZ46 {

    //    模拟
    public static int LastRemaining_Solution(int n, int m) {

        if (n <= 0 || m <= 0) {
            return -1;
        }

//        使用ArrayList不会有指针问题
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = -1;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;
        }
        return list.get(0);
    }

    /**
     * 用数学归纳法找出规律：
     * f[1]=0;
     * f[i]=(f[i-1]+m)%i; (i>1)
     *
     * @param n
     * @param m
     * @return
     */
    //    递归 每次删除的元素下标一定是m%n
    public static int LastRemaining_Solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        return jisuan(n, m);
    }

    public static int jisuan(int n, int m) {
        if (n == 1) {
            return 0;
        }

        int x = jisuan(n - 1, m);

        return (x + m) % n;
    }

    //    迭代
    public static int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

//        当n=1时，返回的结果是0
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }

        return result;
    }


    public static void main(String[] args) {

        int n = 5, m = 3;

        System.out.println(LastRemaining_Solution(n, m));

        System.out.println(LastRemaining_Solution1(n, m));

        System.out.println(LastRemaining_Solution2(n, m));

    }
}
