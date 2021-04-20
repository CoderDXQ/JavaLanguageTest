package com.example.writtenexaminationandinterview.bitmap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 9:34 上午
 */
//实现一个bitmap 使用byte类型实现
//实际上还是标记数组 只不过不是用下标来标记  一个bit就是一个数
public class Mybitmap1 {

    private byte[] bits;

    private int capacity;

    public Mybitmap1(int capacity) {
        this.capacity = capacity;
        bits = new byte[(capacity >> 3) + 1];
    }

    public void add(int num) {
        int index = num >> 3;
        int posttion = num & 0x07;
        bits[index] |= 1 << posttion;
    }

    public boolean contain(int num) {
        int index = num >> 3;
        int position = num & 0x07;

        return (bits[index] & (1 << position)) != 0;
    }

    //    使用位运算进行清除
    public void clear(int num) {

        int index = num >> 3;
        int position = num & 0x07;

//        使用1<<position找到要操作的那一位 然后取反使那一位变成0  然后进行位与运算即可完成清除操作
        bits[index] &= ~(1 << position);

    }

    public static void main(String[] args) {

        Mybitmap1 mybitmap1 = new Mybitmap1(10000000);
        mybitmap1.add(6);
        System.out.println(mybitmap1.contain(7));
        System.out.println(mybitmap1.contain(6));

        mybitmap1.add(99999);
        System.out.println(mybitmap1.contain(99999));

        mybitmap1.clear(6);
        System.out.println(mybitmap1.contain(6));

    }

}
