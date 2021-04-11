package com.example.writtenexaminationandinterview.gongsibishi.webank;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 7:17 下午
 */
public class t3 {


    //    只考虑所有积木都用的情况
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        while (k > 0) {
            int n = in.nextInt();

            int sum = 0;
            Integer[] nums = new Integer[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                sum += nums[i];
            }

//            从小到大排序
            Arrays.sort(nums);

            boolean tichu = false;
//            剃除
            if (sum % 3 == 1) {

                for (int i = 0; i < nums.length; i++) {

                    if (nums[i] % 3 == 1) {
                        sum -= nums[i];
                        nums[i] = -1;
                        tichu = true;
                        break;
                    }
                }

                if (tichu == false) {
                    int num = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (nums[i] % 3 == 2) {
                            sum -= nums[i];
                            nums[i] = -1;
                            num++;
                            if (num == 2) {
                                tichu = true;
                                break;
                            }
                        }
                    }
                }

            } else if (sum % 3 == 2) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 3 == 2) {
                        sum -= nums[i];
                        nums[i] = -1;
                        tichu = true;
                        break;
                    }
                }

                if (tichu == false) {
                    int num = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (nums[i] % 3 == 1) {
                            sum -= nums[i];
                            nums[i] = -1;
                            num++;
                            if (num == 2) {
                                tichu = true;
                                break;
                            }
                        }
                    }
                }

            }


            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            boolean has0 = false;
            for (int i : nums) {
                if (i == 0) {
                    has0 = true;
                }
            }


            if (sum % 3 == 0 && has0 == true) {
                for (int i : nums) {
                    if (i != -1) {
                        System.out.print(i);
                    }
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
            k--;
        }
    }

}
