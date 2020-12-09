package com.example.brushalgorithmproblem.binarytree.binarywithoutrecursion;

import java.util.Stack;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/9 12:00 下午
 */
public class BinaryTreeWithoutRecursion {

    //    内部类
    public class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {

    }

    public void preOrder(Node node) {
        System.out.println("非递归前序遍历");

        if (node == null) return;

        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.empty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }
        System.out.println();
    }

    public void inOrder(Node node) {
//        中序遍历即左根右，意思是一直向左找，然后输出根节点，然后向右找一个再循环往复
        if (node == null) return;
        Stack<Node> stack = new Stack<Node>();

        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                stack.push(node.right);
            }
        }

    }

    public void postOrder(Node node) {
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
            System.out.println(stack2.pop().value);
        }


    }
}


