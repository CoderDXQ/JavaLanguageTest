package com.example.brushalgorithmproblem.leetcodehot100;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/4 8:39 下午
 */
//实现Trie(前缀树)
public class lt208 {

    private lt208[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public lt208() {
        children = new lt208[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        lt208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new lt208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        lt208 node = searchPrefix(word);
//        完全匹配才证明搜索到了
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
//    要求不完全相符的才是前缀匹配
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    //    搜索前缀
    private lt208 searchPrefix(String prefix) {
        lt208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }


    public static void main(String[] args) {

        lt208 trie = new lt208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True

    }

}
