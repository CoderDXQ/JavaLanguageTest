package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/26 12:36 下午
 */
//二叉树的最近公共祖先
public class lt236 {

    public static TreeNode ans;

    //    DFS
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

//        只要下面包含p或者q就行
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

//        更改最近公共祖先的值     当(root.val == p.val || root.val == q.val)时，说明此时的root就是p,q之一 此时如果left或者right有一个为true，那么就同时找到p和q了
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            ans = root;
        }

        return left || right || root.val == p.val || root.val == q.val;
    }


    public static HashMap<Integer, TreeNode> hashMap;

    //    存储父节点
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

//        初始化
        hashMap = new HashMap<>();
//        生成所有节点与其父节点的键值对
        dfs1(root);

//        记录p的所有通向根节点的路径 如果q从下往上找的过程中有重复 那么这就是最近公共祖先
        Set<Integer> set = new HashSet<>();
//        记录p的所有通向根节点的路径
        while (p != null) {
            set.add(p.val);
            p = hashMap.get(p.val);
        }

        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = hashMap.get(q.val);
        }

        return null;
    }

    //    生成所有节点与其父节点的键值对
    public static void dfs1(TreeNode root) {

        if (root.left != null) {
            hashMap.put(root.left.val, root);
            dfs1(root.left);
        }
        if (root.right != null) {
            hashMap.put(root.right.val, root);
            dfs1(root.right);
        }

    }

    public static void main(String[] args) {
        String[] tree = new String[]{"3", "5", "1", "6", "2", "0", "8", null, null, "7", "4"};
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(lowestCommonAncestor(BinaryTreeUtils.create(tree), p, q).val);
        System.out.println(lowestCommonAncestor1(BinaryTreeUtils.create(tree), p, q).val);
    }

}
