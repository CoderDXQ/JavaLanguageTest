package com.example.datastructure.binarytree.huffmantree;

import com.example.datastructure.binarytree.linkcluebinnarytree.LinkClueBinnaryTree;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/27 3:14 下午
 */
//REFERENCE:https://blog.csdn.net/qq_31709249/article/details/103208057
//哈夫曼树常用于压缩
public class HuffmanTree<T extends HuffBaseType> extends LinkClueBinnaryTree<T> {

    //    在构造函数中完成一切
    public HuffmanTree(LinkedList<T> data) {

//        降序排序
        data.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o2.compare(o1) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        LinkedList<Node<T>> nodeList = new LinkedList<>();

//        存储结点
        for (HuffBaseType type : data) {
            Node<T> node = new Node(type);
            nodeList.add(node);
        }

        while (nodeList.size() > 1) {

            Node<T> minNode1 = nodeList.pop();
            Node<T> minNode2 = nodeList.pop();

            HuffBaseType newData = new HuffBaseType(minNode1.getData().id + minNode2.getData().id, minNode1.getData().weight + minNode2.getData().weight);

            Node<T> newRoot = new Node(newData);
            newRoot.setlChild(minNode1);
            newRoot.setrChild(minNode2);

            int i = 0;
//            寻找插入位置
            for (; i < nodeList.size(); i++) {
                Node<T> element = nodeList.get(i);
                if (element.getData().compare(newData) > 0) {
                    nodeList.add(i, newRoot);
                    break;
                }
            }

            if (i == nodeList.size()) {
                nodeList.add(newRoot);
            }

            this.root = newRoot;

        }

//        中序线索化
        midTraverseClue(root);

    }


    //    输出
    public void printHuffCode(Node node, String code) {

        if (node != null) {

            if (node.isLeafNode()) {
                System.out.println(node.getData() + "的Huffman编码为：" + code);
            } else {
                if (node.getlChild() != null) {
                    printHuffCode(node.getlChild(), code + "0");
                }

                if (node.getrChild() != null) {
                    printHuffCode(node.getrChild(), code + "1");
                }

            }

        }

    }


    public void printHuffCode() {
        printHuffCode(root, "");
    }


    public static void main(String[] args) {

        LinkedList<HuffBaseType> datas = new LinkedList<>();
        datas.add(new HuffBaseType("A", 9));
        datas.add(new HuffBaseType("B", 4));
        datas.add(new HuffBaseType("C", 5));
        datas.add(new HuffBaseType("D", 2));

//        在构造函数中就会进行建树的操作
        HuffmanTree<HuffBaseType> huffmanTree = new HuffmanTree<>(datas);
        huffmanTree.print(3);
        huffmanTree.printHuffCode();

    }


}
