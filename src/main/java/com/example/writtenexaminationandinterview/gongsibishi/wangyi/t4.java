package com.example.writtenexaminationandinterview.gongsibishi.wangyi;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/10 2:53 下午
 */
public class t4 {

    public static int GetBestWarehouseLocate(int[][] distancePairs, int CityNum) {

        if(CityNum==1){
            return 0;
        }
        // write code here
        HashMap<Integer, Set<Integer>> keda = new HashMap<>();
        HashMap<Integer, int[]> jvli = new HashMap<>();

        for (int i = 0; i < distancePairs.length; i++) {
            int a = distancePairs[i][0];
            int b = distancePairs[i][1];
            int c = distancePairs[i][2];

//            a-b
            if (!keda.containsKey(a)) {
                Set<Integer> set = new HashSet<>();
                set.add(b);
                keda.put(a, set);

                int[] nums = new int[CityNum];
                nums[b] = c;
                jvli.put(a, nums);

            }
//            b-a
            if (!keda.containsKey(b)) {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                keda.put(b, set);

                int[] nums = new int[CityNum];
                nums[a] = c;
                jvli.put(b, nums);
            }

            Set<Integer> set = keda.get(a);
            set.add(b);
            keda.put(a, set);

            set = keda.get(b);
            set.add(a);
            keda.put(b, set);

            int[] nums = jvli.get(a);
            nums[b] = c;
            jvli.put(a, nums);

            nums = jvli.get(b);
            nums[a] = c;
            jvli.put(b, nums);

        }

        int result = -1;
        int s = Integer.MAX_VALUE;

        for (Integer i : keda.keySet()) {
            Set<Integer> set = keda.get(i);
            if (set.size() == CityNum-1) {
                int sum = 0;
                int[] nums = jvli.get(i);
                for (int a : nums) {
                    sum += a;
                }

                if (s > sum) {
                    s = sum;
                    result = i;
                }

            }
        }


        return result;
    }


    public static void main(String[] args) {


        int[][] distancePairs = new int[][]{{0, 1, 3}, {1, 2, 2}};
        int[][] distancePairs1 = new int[][]{{0, 1, 3}, {1, 2, 2}, {0, 2, 1}};
        System.out.println(GetBestWarehouseLocate(distancePairs, 3));
        System.out.println(GetBestWarehouseLocate(distancePairs1, 3));


    }
}
