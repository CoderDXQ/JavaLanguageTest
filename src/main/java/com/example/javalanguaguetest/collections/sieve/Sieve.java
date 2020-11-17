package com.example.javalanguaguetest.collections.sieve;

import java.util.BitSet;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/17 3:30 下午
 */
public class Sieve {

    //素数倍筛法   欧拉筛法效率更高
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        //给位集的每个位赋值
        for (i = 2; i <= n; i++)
            b.set(i);
        i = 2;
        while (i * i <= n) {
            //从位集中获取某个值 成功为true，失败为false
            if (b.get(i)) {
                count++;
                int k = i * 2;
                while (k <= n) {
                    //从位集中删除某个值
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        //计算素数的总个数
        while (i <= n) {
            if (b.get(i)) count++;
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
