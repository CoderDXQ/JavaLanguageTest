package com.example.datastructure.binarytree.huffmantree;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/27 3:07 下午
 */
public class HuffBaseType {

    protected String id;//结点ID
    protected int weight;//权重

    public HuffBaseType(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    //    用于比较 可自定义
    public int compare(HuffBaseType type) {

        if (this.weight > type.weight) {
            return 1;
        } else if (this.id == type.id) {
            return 0;
        }

        return -1;

    }

    @Override
    public String toString() {
        return "HuffBaseType{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }

}
