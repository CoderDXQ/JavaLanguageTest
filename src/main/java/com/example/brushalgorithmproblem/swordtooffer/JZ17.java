package com.example.brushalgorithmproblem.swordtooffer;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/1 9:20 下午
 */
public class JZ17 {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

//        if (root1.val == root2.val && check(root1, root2)) {
//            return true;
//        } else {
////            这里需要用或运算
//            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
//        }

//        检查当前节点和左右子节点
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    //    这里用递归来实现 判断传进来的两棵树有没有包含关系
    public static boolean check(TreeNode root1, TreeNode root2) {

//        子树当前节点为null说明子树的这个分支遍历完了 无论母树对应分支能不能继续往下走 这个分支上的结果都是true 返回后需要继续计算
        if (root2 == null) {
            return true;
        }

//        能走到这里说明子树节点没有遍历完 但是母树完了
        if (root1 == null) {
            return false;
        }

//        能走到这里说明子树和母树都没有遍历完
        if (root1.val != root2.val) {
            return false;
        }

//        这个地方是且运算
        return check(root1.left, root2.left) && check(root1.right, root2.right);

    }

    public static void main(String[] args) {
        String[] tree1 = new String[]{"8", "8", "#", "9", "#", "2", "#", "5"};

//        返回false
//        String[] tree2 = new String[]{"8", "9", "#", "2", "7"};

        //        返回true
        String[] tree2 = new String[]{"8", "9", "#", "2"};

        TreeNode root1 = BinaryTreeUtils.create(tree1);
        TreeNode root2 = BinaryTreeUtils.create(tree2);

        System.out.println(HasSubtree(root1, root2));
    }
}
