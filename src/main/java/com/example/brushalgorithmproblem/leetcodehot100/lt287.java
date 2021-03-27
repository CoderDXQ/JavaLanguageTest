package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/27 11:46 下午
 */

//寻找重复数
public class lt287 {

    //    二分法 注意边界条件
    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int cnt = 0;
            int mid = (left + 1 + right + 1) >> 1;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] < mid) {
                    cnt++;
                }
            }
            if (cnt < mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left == right) {
            return left;
        }
        return 0;
    }


    //    空间标记法
    public static int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] % nums.length) - 1] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length * 2) {
                return i + 1;
            }
        }
        return 0;
    }


    //    这是最快的方法
    //    重复必定有环 使用快慢指针找出环的入口即可 Floyd判圈算法
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
//        do...while循环可以解决初始值与条件冲突而不能进入循环体的问题
        do {
//            认为数组的下标是起始点 值是终点
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
    }

}
