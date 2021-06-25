package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:44 下午
 */
//寻找两个正序数组的中位数
public class lt4 {

    //    二分查找变形
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

//        剩余的两个计算中数组的长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

//        保持len1始终是长度短的那一个
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
//        剪枝
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

//        被比较的下标
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
//            截取nums2
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
//            截取nums1
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }


    //    暴力
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        if (m == 0) {
            if ((n & 1) == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if ((m & 1) == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while ((i != m)) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if ((count & 1) == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    //    划分数组
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        return 0;
    }

    //    利用中位数的定义
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {

        return 0;
    }

    //    暴力方法优化
    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = ((m + n) >> 1) + 1;
        int[] nums = new int[len];

        if (m == 0) {
            if ((n & 1) == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if ((m & 1) == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }


        int target = (m + n) >> 1;
        int sum = m + n;

        int count = 0;
        int i = 0, j = 0;
        while (count != target) {
            if (i == m) {
                while (j != n && count != target) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while ((i != m && count != target)) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if ((sum & 1) == 0) {
            return (nums[target - 1] + nums[target]) / 2.0;
        } else {
            return nums[target];
        }
    }

    //    暴力方法继续优化 这是对上面的方法的进一步优化
    public static double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
//        循环记录
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
//        类似于循环数组的思想
//        不管两个数组的个数和是奇是偶 循环的次数总是一样的
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }


    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        int[] nums3 = new int[]{1, 2};
        int[] nums4 = new int[]{3, 4};

        int[] nums5 = new int[]{0, 0};
        int[] nums6 = new int[]{0, 0};

        int[] nums7 = new int[]{};
        int[] nums8 = new int[]{1};

        int[] nums9 = new int[]{2};
        int[] nums10 = new int[]{};


        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
        System.out.println(findMedianSortedArrays(nums5, nums6));
        System.out.println(findMedianSortedArrays(nums7, nums8));
        System.out.println(findMedianSortedArrays(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays1(nums1, nums2));
        System.out.println(findMedianSortedArrays1(nums3, nums4));
        System.out.println(findMedianSortedArrays1(nums5, nums6));
        System.out.println(findMedianSortedArrays1(nums7, nums8));
        System.out.println(findMedianSortedArrays1(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays2(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums3, nums4));
        System.out.println(findMedianSortedArrays2(nums5, nums6));
        System.out.println(findMedianSortedArrays2(nums7, nums8));
        System.out.println(findMedianSortedArrays2(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays3(nums1, nums2));
        System.out.println(findMedianSortedArrays3(nums3, nums4));
        System.out.println(findMedianSortedArrays3(nums5, nums6));
        System.out.println(findMedianSortedArrays3(nums7, nums8));
        System.out.println(findMedianSortedArrays3(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays4(nums1, nums2));
        System.out.println(findMedianSortedArrays4(nums3, nums4));
        System.out.println(findMedianSortedArrays4(nums5, nums6));
        System.out.println(findMedianSortedArrays4(nums7, nums8));
        System.out.println(findMedianSortedArrays4(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays5(nums1, nums2));
        System.out.println(findMedianSortedArrays5(nums3, nums4));
        System.out.println(findMedianSortedArrays5(nums5, nums6));
        System.out.println(findMedianSortedArrays5(nums7, nums8));
        System.out.println(findMedianSortedArrays5(nums9, nums10));

        System.out.println();


    }

}
