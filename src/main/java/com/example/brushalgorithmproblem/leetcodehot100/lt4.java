package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/19 10:44 下午
 */
//寻找两个正序数组的中位数
public class lt4 {

    //    二分查找变形 递归实现
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int left = (len + 1) / 2;
        int right = (len + 2) / 2;

//        len为奇数时 只需要计算一个结果即可
        if ((len & 1) == 1) {
            return getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);
        } else {
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }
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
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
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

    //    划分数组 划分之后进行二分查找
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
//        确保m是比较少的那个数
        if (m > n) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int min = 0, max = m;
//        使用min和max来控制二分的进行
        while (min < max) {
            int i = (min + max) >> 1;
            int j = ((m + n + 1) >> 1) - i;
//            二分查找
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                //nums1下标+1 nums2中当前的下标的数值大于nums1下一个下标的数值
                min = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                //nums1下标+1 nums2中当前的下标的数值大于nums1下一个下标的数值
                max = i - 1;
            } else {
//                i,j有其一到达了左右边界之一 或者 nums2[j - 1] <= nums1[i]&&nums1[i - 1] <= nums2[j]即划分出来左侧两段的最大值小于右侧两段的最小值
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
//                    左侧的值 选大的
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
//                如果是奇数则不需要计算右值
                if (((m + n) & 1) == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
//                    右侧的值选小的
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
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

    //    直接进行二分查找 非递归实现
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totallen = len1 + len2;
        if ((totallen & 1) == 1) {
            int mid = totallen >> 1;
            return getKthEle(nums1, nums2, mid);
        } else {
            int right = totallen >> 1, left = right - 1;
            return (getKthEle(nums1, nums2, left) + getKthEle(nums1, nums2, right)) * 0.5;
        }
    }

    //    ???可能需要再调试
    private static double getKthEle(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthEle = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k];
            }
            if (index2 == len2) {
                return nums1[index1 + k];
            }
            if (k == 0) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k >> 1;
            int newIndex1 = Math.min(index1 + half, len1);
            int newIndex2 = Math.min(index2 + half, len2);
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
//            ???k的表达式是否需要调整一下
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1);
                index1 = newIndex1;
            } else {
                k -= (newIndex2 - index2);
                index2 = newIndex2;
            }
        }
    }

    //    动态规划 记忆数组 直接计算所有可能的中位的情况然后直接校验是否满足中位条件
    public static double findMedianSortedArrays6(int[] nums1, int[] nums2) {

        return 0;
    }

    //    划分数组优化+二分查找
    public static double findMedianSortedArrays7(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays7(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int left_max = 0, right_min = 0;

        while (left <= right) {
            int i = (left + right) >> 1;
            int j = ((m + n + 1) >> 1) - i;

            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                left_max = Math.max(nums_im1, nums_jm1);
                right_min = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return ((m + n) & 1) == 0 ? (left_max + right_min) * 0.5 : left_max;
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

        System.out.println(findMedianSortedArrays6(nums1, nums2));
        System.out.println(findMedianSortedArrays6(nums3, nums4));
        System.out.println(findMedianSortedArrays6(nums5, nums6));
        System.out.println(findMedianSortedArrays6(nums7, nums8));
        System.out.println(findMedianSortedArrays6(nums9, nums10));

        System.out.println();

        System.out.println(findMedianSortedArrays7(nums1, nums2));
        System.out.println(findMedianSortedArrays7(nums3, nums4));
        System.out.println(findMedianSortedArrays7(nums5, nums6));
        System.out.println(findMedianSortedArrays7(nums7, nums8));
        System.out.println(findMedianSortedArrays7(nums9, nums10));

        System.out.println();

    }

}
