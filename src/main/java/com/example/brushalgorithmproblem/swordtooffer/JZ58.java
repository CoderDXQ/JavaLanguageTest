package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 10:38 下午
 */
public class JZ58 {

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return check(pRoot.left, pRoot.right);
    }

    public static boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

//        比较两个节点的值和两个节点的两个孩子的值 取交
        return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right, root2.left);
    }


    public static void main(String[] args) {
        int[] trees1 = new int[]{8, 6, 6, 5, 7, 7, 5};
        int[] trees2 = new int[]{8, 6, 9, 5, 7, 7, 5};

//        true
        System.out.println(isSymmetrical(BinaryTreeUtils.create1(trees1)));
//        false
        System.out.println(isSymmetrical(BinaryTreeUtils.create1(trees2)));

    }
}
