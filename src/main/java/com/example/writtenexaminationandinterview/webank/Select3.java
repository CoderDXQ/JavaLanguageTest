package com.example.writtenexaminationandinterview.webank;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/6 9:07 下午
 */
public class Select3 {

    //    private static final int counter = 10;
//    final在构造函数之后加了一个StoreStore屏障 后面的不能再写了
    private static int counter = 10;

    public static void main(String[] args) {
//        因为有final修饰 编译时出错
        System.out.println(++counter);
    }

}
