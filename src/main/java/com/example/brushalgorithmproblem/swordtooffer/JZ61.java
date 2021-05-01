package com.example.brushalgorithmproblem.swordtooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/3 11:33 上午
 */
//序列化二叉树
public class JZ61 {

    public static int index = 0;

    /**
     * 在java中，null与空是不相同的
     */

    //    先序遍历
    public static String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    //    先序遍历
    public static TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
//        每次都要初始化
        index = 0;
        return check(strings);
    }

    public static TreeNode check(String[] strings) {
        if (strings[index].equals("#")) {
//            index的自增不能放到上面的括号里  否则即使不返回null，index也会自增1
            index++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(strings[index++]));
            node.left = check(strings);
            node.right = check(strings);
            return node;
        }
    }

    //层序遍历
    public static String Serialize1(TreeNode root) {

        String str = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                str += "#";
            } else {

                if (node.left == null) {
                    queue.offer(null);
                } else {
                    queue.offer(node.left);
                }
                if (node.right == null) {
                    queue.offer(null);
                } else {
                    queue.offer(node.right);
                }

                str += node.val;
            }

            if (!queue.isEmpty()) {
                str += ",";
            }
        }

        return str;
    }

    //层序遍历
    public static TreeNode Deserialize1(String str) {

        String[] strings = str.split(",");
        TreeNode[] trees = new TreeNode[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("#")) {
                trees[i] = null;
            } else {
//                将字符串转化为数字
                trees[i] = new TreeNode(Integer.parseInt(strings[i]));
            }
        }

        int index = 1;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] != null) {
                trees[i].left = trees[index++];
                trees[i].right = trees[index++];
            }
            if (index >= trees.length) {
                break;
            }
        }
        return trees[0];
    }

    public static void main(String[] args) {
        int[] tree1 = new int[]{8, 6, 10, 5, 7, 9, 11};

        TreeNode root = BinaryTreeUtils.create1(tree1);

        String result = Serialize(root);
        System.out.println(result);

        BinaryTreeUtils.layerOrder(Deserialize(result));

    }
}
