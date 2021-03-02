package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/2 10:46 下午
 */
public class JZ23 {
    /**
     * 后序遍历:数组的最后一个元素就是根节点
     * 二叉搜索树:左子树全部小于根节点，右子树全部大于根节点
     */

//    递归分割法
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 1) {
            return true;
        }
        if (sequence.length == 0) {
            return false;
        }

        return check(sequence, 0, sequence.length - 1);
    }

    public static boolean check(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = left;
//        寻找左右子树分界点
        for (; i < right; i++) {
            if (sequence[i] > sequence[right]) {
                break;
            }
        }
//        检查右子树
        for (int j = i; j < right; j++) {
            if (sequence[j] < sequence[right]) {
                return false;
            }
        }
//        判断左右子树
        return check(sequence, left, i - 1) && check(sequence, i + 1, right);
    }

    //数组的最后一个元素可以把前面的数组分成两部分，左边一部分小于他，右边一部分大于他 用这个来检测即可
    //从右往左检查所有元素
    public static boolean VerifySquenceOfBST1(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int last = sequence.length - 1;
        int head = 0;
        while (last > 0) {
            head = 0;

//            左边一部分小于他
            while (sequence[head] < sequence[last]) {
                head++;
            }
//            右边一部分大于他
            while (sequence[head] > sequence[last]) {
                head++;
            }
//            如果没有到达他的位置 就说明左边出了问题  即 左子树中出了大于他的数或者右子树中出了小于他的数
            if (head != last) {
                return false;
            }
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 12, 16, 14, 10};

        System.out.println(VerifySquenceOfBST(arr));
        System.out.println(VerifySquenceOfBST1(arr));
    }
}
