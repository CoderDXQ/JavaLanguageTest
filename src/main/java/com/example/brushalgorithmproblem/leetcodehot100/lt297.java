package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/5/1 6:40 下午
 */
//二叉树的序列化与反序列化
public class lt297 {

    public static String str;

    //    随便改个遍历 本质上是DFS
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
//        初始化
        str = "";
        return rserialize(root);
    }

    public static String rserialize(TreeNode root) {

        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            rserialize(root.left);
            rserialize(root.right);
        }
        return str;

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return rdeserialize(list);
    }

    public static TreeNode rdeserialize(List<String> l) {

        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    //    层序遍历 基于完全二叉树
    public static String serialize1(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                result += String.valueOf(node.val) + ",";
            } else {
                result += "#,";
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return result;
    }

    // 反序列化的时候实际上也是层序遍历  在层序遍历的过程中从数组中还原树结构
    public static TreeNode deserialize1(String data) {

        if (data.length() == 0 || data == null || data == "") {
            return null;
        }

        String[] array = data.split(",");

        if (array.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.valueOf(array[0]));

        queue.offer(root);

//        这样写其实就是while循环
        for (int i = 1; i < array.length; ) {

            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            String left = array[i++];
            if (left.equals("#")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(left));
            }
//            维护层序顺序
            queue.offer(node.left);

            String right = array[i++];
            if (right.equals("#")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(right));
            }
            queue.offer(node.right);

        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = BinaryTreeUtils.create(new String[]{"1", "2", "3", null, null, "4", "5"});

//        BinaryTreeUtils.layerOrder(root);
//        System.out.println();

        System.out.println(serialize(root));

        System.out.println(deserialize(serialize(root)).toString());

        System.out.println(serialize1(root));

        System.out.println(deserialize1(serialize1(root)).toString());

    }

}
