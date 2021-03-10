package com.example.datastructure.binarytree;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/9 12:00 下午
 */
public class BinaryTreeWithoutRecursion {

    //    内部类
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        BinaryTreeWithoutRecursion bt = new BinaryTreeWithoutRecursion();

        Node node4 = new Node(5, null, null);
        Node node5 = new Node(2, null, null);
        Node node2 = new Node(7, node4, null);
        Node node3 = new Node(4, null, node5);
        Node root1 = new Node(1, node2, node3);

        bt.preOrder(root1);//输出结果：17542
        bt.inOrder(root1);
        bt.postOrder(root1);
    }

    public void preOrder(Node node) {
        System.out.println("非递归前序遍历");

        if (node == null) return;

        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.empty()) {
            Node curNode = stack.pop();
            System.out.print(curNode.value + " ");
            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }
        System.out.println();
    }

    public void inOrder(Node node) {
        System.out.println("非递归中序遍历");
//        中序遍历即左根右，意思是一直向左找，然后输出根节点，然后向右找一个再循环往复
        if (node == null) return;
        Stack<Node> stack = new Stack<Node>();

        while (node != null || !stack.empty()) {
            //按照完全二叉树的形式进行中序遍历，如果节点为空就不放进栈，在这里栈保存的是中序遍历的顺序
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
        System.out.println();
    }

    public void postOrder(Node node) {
        System.out.println("非递归后序遍历");
//        这里的思路是一个反向的先序遍历

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

//        从stack1向stack2中灌
        stack1.push(node);
        while (!stack1.empty()) {
            node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.empty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }
}


