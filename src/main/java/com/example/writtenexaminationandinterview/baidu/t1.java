package com.example.writtenexaminationandinterview.baidu;


import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 6:38 下午
 */
public class t1 {


    /**
     * public static void main(String[] args) {
     * <p>
     * Scanner in = new Scanner(System.in);
     * int n = in.nextInt();
     * int[] a = new int[n];
     * int[] jilu = new int[n];
     * <p>
     * in.nextLine();
     * String s = in.nextLine();
     * for (int i = 0; i < s.length(); i++) {
     * a[i] = s.charAt(i) - '0';
     * //            只记录最后一个位置
     * jilu[a[i]] = i;
     * }
     * <p>
     * //        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
     * //        for (int i = 0; i < n; i++) {
     * //            //这里可能有问题 先用这个
     * //        }
     * <p>
     * int[] dp = new int[n];
     * Arrays.fill(dp, 1000000);
     * dp[0] = 0;
     * for (int i = 0; i < n; i++) {
     * if (i > 0) {
     * dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
     * }
     * if (jilu[a[i]] > i) {
     * dp[jilu[a[i]]] = Math.min(dp[i] + 1, dp[jilu[a[i]]]);
     * }
     * }
     * <p>
     * System.out.println(dp[n-1]);
     * <p>
     * }
     **/

    public static int hhh(String s, int n) {

        int[] a = new int[n];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
            if (hashMap.containsKey(a[i])) {
                hashMap.get(a[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(a[i], list);
            }
        }


        int[] dp = new int[n];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {

            int x = -1;
            if (hashMap.containsKey(a[i])) {
                x = hashMap.get(a[i]).get(0);
                if (x != -1) {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[x] + 1);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        in.nextLine();
        String s = in.nextLine();

        System.out.println(hhh(s, n));


    }

}
