package com.example.brushalgorithmproblem;

import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/30 9:55 上午
 */
//克隆图 深拷贝就是需要重新分配存储空间
public class lt133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    //    如果某个点已经被克隆过了就直接返回克隆体
    public static HashMap<Node, Node> visited = new HashMap<>();

    //    DFS
    public static Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node, cloneNode);

//        深度搜索
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }


    //    BFS
    public static Node cloneGraph1(Node node) {

        if (node == null) {
            return node;
        }

        HashMap<Node, Node> hashMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        hashMap.put(node, new Node(node.val, new ArrayList<>()));

//        使用BFS克隆图
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {
                if (!hashMap.containsKey(neighbor)) {
//                    放入新节点
                    hashMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
//                    放入队列
                    queue.add(neighbor);
                }
//                构建邻接表
                hashMap.get(n).neighbors.add(hashMap.get(neighbor));
            }
        }

        return hashMap.get(node);
    }


    public static void main(String[] args) {

    }

}
