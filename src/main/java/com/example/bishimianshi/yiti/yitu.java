package com.example.bishimianshi.yiti;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/2 10:58 上午
 */
//lt124
public class yitu {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static TreeNode create(String[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == "#" || tree[0] == null) {
            return null;
        }

//        创建二叉树的节点数组
        TreeNode[] binaryTree = new TreeNode[tree.length];
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == "#" || tree[i] == null) {
                binaryTree[i] = null;
            } else {
                binaryTree[i] = new TreeNode(Integer.valueOf(tree[i]));
            }
        }

//        连接二叉树
        int k = 1;
        for (int i = 0; i < binaryTree.length; i++) {
            if (binaryTree[i] != null) {
                if (k < binaryTree.length) {
                    binaryTree[i].left = binaryTree[k++];
                }
                if (k < binaryTree.length) {
                    binaryTree[i].right = binaryTree[k++];
                }
            }
        }

        return binaryTree[0];
    }


    public static int maxValue;

    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        dfs(root);
        return maxValue;
    }

    public static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

//        当前节点的最大路径和
        int num = root.val + left + right;

        maxValue = Math.max(num, maxValue);

//        返回当前节点最大的半条路径
        return root.val + Math.max(left, right);

    }


    public static void main(String[] args) {
        int[] tree0 = new int[]{1, 2, 3};
        String[] tree1 = new String[]{"-10", "9", "20", null, null, "15", "7"};

        System.out.println(maxPathSum(create(tree1)));
    }

}
