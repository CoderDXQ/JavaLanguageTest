package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:42 下午
 */
//打家劫舍III
public class lt337 {

    //    p是选择这个节点
    public static Map<TreeNode, Integer> p;
    //    g是不选这个节点
    public static Map<TreeNode, Integer> g;

    //    动态规划  树形DP 从下往上
    public static int rob(TreeNode root) {

//        初始化
        p = new HashMap<>();
        g = new HashMap<>();

        dfs(root);

        return Math.max(p.getOrDefault(root, 0), g.getOrDefault(root, 0));

    }

    private static void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);

        p.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(g.getOrDefault(root.left, 0), p.getOrDefault(root.left, 0)) + Math.max(g.getOrDefault(root.right, 0), p.getOrDefault(root.right, 0)));

    }

    //    动态规划  树形DP 从下往上 空间复杂度优化
    public static int rob2(TreeNode root) {

        int[] rootStatus = dfs1(root);

        return Math.max(rootStatus[0], rootStatus[1]);

    }

    private static int[] dfs1(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }
//        数组只有两个元素 分别是选当前节点和不选当前节点的情况
        int[] l = dfs1(root.left);
        int[] r = dfs1(root.right);

        int selected = root.val + l[1] + r[1];
        int notselected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[]{selected, notselected};
    }


    //    记忆化搜索
    public static int rob1(TreeNode root) {

        HashMap<TreeNode, Integer> mem = new HashMap<>();
        return dfs2(root, mem);

    }

    private static int dfs2(TreeNode root, HashMap<TreeNode, Integer> mem) {

        if (root == null) {
            return 0;
        }
        if (mem.containsKey(root)) {
            return mem.get(root);
        }

        int money = root.val;

//        选择当前节点  那么左右子节点就不能选了
        if (root.left != null) {
            money += (dfs2(root.left.left, mem) + dfs2(root.left.right, mem));
        }

        if (root.right != null) {
            money += (dfs2(root.right.left, mem) + dfs2(root.right.right, mem));
        }

        int result = Math.max(money, dfs2(root.left, mem) + dfs2(root.right, mem));

        mem.put(root, result);

        return result;

    }

    public static void main(String[] args) {

        TreeNode root = BinaryTreeUtils.create(new String[]{"3", "2", "3", null, "3", null, "1"});
        TreeNode root1 = BinaryTreeUtils.create(new String[]{"3", "4", "5", "1", "3", null, "1"});

        System.out.println(rob(root));
        System.out.println(rob(root1));

        System.out.println();

        System.out.println(rob1(root));
        System.out.println(rob1(root1));

        System.out.println();

        System.out.println(rob2(root));
        System.out.println(rob2(root1));

    }

}
