package com.example.writtenexaminationandinterview.gongsibishi.huawei;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/14 2:46 下午
 */
public class huawei {

    public static void main(String[] args) {
        String[] times = new String[]{ "00:00","23:59"};

        Integer[] nums = new Integer[times.length<<1];

        int k = 0;

        for (String s : times) {
            String[] t = s.split(":");

            int n = Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);

            int n1 = n + 1440;

            nums[k++] = n;
            nums[k++] = n1;

        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }

        System.out.println(min);
    }


}
