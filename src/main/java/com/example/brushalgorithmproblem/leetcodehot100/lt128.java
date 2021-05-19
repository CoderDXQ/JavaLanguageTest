package com.example.brushalgorithmproblem.leetcodehot100;

import java.net.Inet4Address;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/30 9:29 上午
 */
//最长连续序列
public class lt128 {

    //    哈希表
    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int max = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }

                max = Math.max(max, count);

            }

        }

        return max;
    }

    //    排序 时间复杂度取决于Arrays.sort(nums);
    public static int longestConsecutive1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;

//        排序
        Arrays.sort(nums);

        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                count++;
            } else if ((nums[i] == nums[i + 1])) {
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }

        res = Math.max(res, count);
        return res;
    }


    public static Map<Integer, Integer> map;

    //    并查集 巧妙地利用了找爹函数的特性
    public static int longestConsecutive2(int[] nums) {

//        初始化
        map = new HashMap<>();

//        每个key对应的爹就是value
        for (int i : nums) {
            map.put(i, i + 1);
        }

        int ans = 0;

        for (int i : nums) {
//            找到底之后就是连续序列的右边最大的值
            int y = find(i + 1);
            ans = Math.max(ans, y - i);
        }

        return ans;
    }

    public static Integer find(int x) {
//        return map.containsKey(x) ? map.put(x, find(map.get(x))) : x;
//        存在就接着往下找爹
        return map.containsKey(x) ? find(map.get(x)) : x;

    }


    public static void main(String[] args) {

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums1 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));

        System.out.println();

        System.out.println(longestConsecutive1(nums));
        System.out.println(longestConsecutive1(nums1));

        System.out.println();

        System.out.println(longestConsecutive2(nums));
        System.out.println(longestConsecutive2(nums1));


    }

}
