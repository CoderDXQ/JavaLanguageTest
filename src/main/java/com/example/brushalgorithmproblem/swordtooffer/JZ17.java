package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:20 下午
 */
public class JZ17 {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {


    }

    public static void main(String[] args) {
        String[] tree1 = new String[]{"8", "8", "#", "9", "#", "2", "#", "5"};
        String[] tree2 = new String[]{"8", "9", "#", "2"};

        TreeNode root1 = BinaryTreeUtils.create(tree1);
        TreeNode root2 = BinaryTreeUtils.create(tree2);

        System.out.println(HasSubtree(root1, root2));
    }
}
