package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/11 11:35 下午
 */
//二叉树的下一个结点
public class JZ57 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        //        存放的是当前节点的父节点指针
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }

//        如果当前节点有右子树(左子树已经被访问过 不需要考虑  肯定不是下一节点)那么下一节点就是右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

//        如果当前节点没有右子树 需要向上查找
//        这样的话  如果当前节点是父节点的右节点 继续需要向上查找
//        如果当前节点是父节点的左节点,那么下一个节点就是父节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
