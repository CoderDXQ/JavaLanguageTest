package com.example.writtenexaminationandinterview.trie;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 11:47 下午
 */
//前缀树 又叫字典树 本质上就是多叉树
public class Trie {

    private class Node {
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }

        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }

//        计算下标
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
//        substring()方法只传入开始的下标，那么结尾的下标默认到最后
        insert(word.substring(1), node.childs[index]);

    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index]);

    }

    public boolean startWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }


    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
//        false
        System.out.println(trie.search("app"));
//        true
        System.out.println(trie.startWith("app"));
//        false
        System.out.println(trie.search("ll"));
//        false
        System.out.println(trie.startWith("lll"));
//        true
        System.out.println(trie.search("apple"));

    }

}
