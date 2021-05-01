package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/4 10:58 上午
 */

/**
 * 排序树的中序遍历就是有序的
 * 树节点的左右子树指针可以做双向链表节点的前后指针
 */
//二叉搜索树与双向链表
public class JZ26 {

    //    他的长度是超长的
    public static TreeNode[] treeNodes = new TreeNode[10000];
    public static int k = 0;

    //    中序遍历
    public static TreeNode Convert1(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

//        初始化
        treeNodes = new TreeNode[10000];
        k = 0;

        InOrderForConvert(pRootOfTree);

        k = 0;
        while (treeNodes[k] != null) {
            if (k == 0) {
                treeNodes[k].right = treeNodes[k + 1];
                k++;
                continue;
            }

            if (treeNodes[k + 1] == null) {
                treeNodes[k].left = treeNodes[k - 1];
                break;
            }
            treeNodes[k].left = treeNodes[k - 1];
            treeNodes[k].right = treeNodes[k + 1];
            k++;
        }

        return treeNodes[0];
    }

    public static void InOrderForConvert(TreeNode root) {
        if (root.left != null) {
            InOrderForConvert(root.left);
        }

        treeNodes[k++] = root;

        if (root.right != null) {
            InOrderForConvert(root.right);
        }
    }


    public static TreeNode preNode = new TreeNode();

    //    不使用数组存储中序遍历
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

//        初始化
        preNode = null;
        check(pRootOfTree);

        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    //    改写中序遍历
    public static void check(TreeNode root) {

        if (root.left != null) {
            check(root.left);
        }
//        operation
        if (preNode != null) {
//            这里存在重复赋值的情况  但是不可避免
            root.left = preNode;
            preNode.right = root;
        }

        preNode = root;

        if (root.right != null) {
            check(root.right);
        }
    }


    //    先遍历右子树的中序遍历 即右根左
    public static TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
//        初始化
        preNode = null;

        return check2(pRootOfTree);
    }

    //   实现先遍历右子树的中序遍历 即右根左
    public static TreeNode check2(TreeNode root) {
        if (root.right != null) {
            check2(root.right);
        }

        if (preNode != null) {
            root.right = preNode;
            preNode.left = root;
        }

        preNode = root;

        if (root.left != null) {
            check2(root.left);
        }
//        preNode是一个全局变量 表示之前访问的最近一个节点
        return preNode;
    }


    public static void main(String[] args) {
        int[] trees = new int[]{4, 2, 6, 1, 3, 5, 7};
        BinaryTreeUtils.inOrder(BinaryTreeUtils.create1(trees));
        System.out.println();
//        System.out.println();
//        BinaryTreeUtils.layerOrder(BinaryTreeUtils.create1(trees));
//        System.out.println();
//        BinaryTreeUtils.postOrer(BinaryTreeUtils.create1(trees));

        TreeNode a = Convert(BinaryTreeUtils.create1(trees));
        while (a.right != null) {
            System.out.print(a.val + "  ");
            a = a.right;
        }
        System.out.println();

        TreeNode b = Convert1(BinaryTreeUtils.create1(trees));
        while (b.right != null) {
            System.out.print(b.val + "  ");
            b = b.right;
        }
        System.out.println();

        TreeNode c = Convert2(BinaryTreeUtils.create1(trees));
        while (c.right != null) {
            System.out.print(c.val + "  ");
            c = c.right;
        }
        System.out.println();

    }

}
