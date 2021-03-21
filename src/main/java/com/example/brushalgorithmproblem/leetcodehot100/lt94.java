package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/21 3:37 下午
 */
//二叉树的中序遍历
public class lt94 {

    public static List<Integer> result;

    //    递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<>();

        inOrder(root);

        return result;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left);
        }

        result.add(root.val);

        if (root.right != null) {
            inOrder(root.right);
        }
    }

    //迭代 非递归 实际上就是使用一个栈来模拟递归
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> results = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

//        迭代的时候 push操作和pop操作要分开
        while (root != null || !stack.empty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            results.add(node.val);
            root = node.right;

        }
        return results;
    }

    //    Morris 莫里斯中序遍历 相比迭代省去了栈的空间复杂度 在树中灵活的加线索可以提高速度和节省内存空间 ？？？需要再理解一下
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode pre = null;

        while (root != null) {
            if (root.left != null) {
//                处理线索  这个线索可以帮助从二叉树某个节点的左子树的最右节点直接跳回根节点
                pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }

                if (pre.right == null) {
//                    添加线索
                    pre.right = root;
//                    切换左子树 再回到while循环
                    root = root.left;
                } else {
//                    能走到这说明已经从根节点的左子树的最右节点跳回了根节点 接下来需要删除线索并切换根节点的右子树
                    result.add(root.val);
//                    消除线索
                    pre.right = null;
//                    切换右子树
                    root = root.right;
                }
            } else {
//                执行根操作
                result.add(root.val);
//                切换右子树 或者跳回小子树的根节点
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] trees = new String[]{"1", null, "2", "3"};

        inorderTraversal(BinaryTreeUtils.create(trees)).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        inorderTraversal1(BinaryTreeUtils.create(trees)).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        inorderTraversal2(BinaryTreeUtils.create(trees)).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

    }
}
