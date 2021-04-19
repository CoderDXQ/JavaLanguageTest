package com.example.javalanguaguetest.bitmap;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 9:26 上午
 */

//实现一个bitmap 使用int类型实现
//实际上还是标记数组 只不过不是用下标来标记  一个bit就是一个数
public class Mybitmap {

    private long length;
    //    一个int是4B，即32bits 也可以用byte
    private static int[] bitsMap;

    //    32个数 用于取位
    private static final int[] BIT_VAE = {0x00000001, 0x00000002, 0x00000004, 0x00000008, 0x00000010, 0x00000020,
            0x00000040, 0x00000080, 0x00000100, 0x00000200, 0x00000400, 0x00000800, 0x00001000, 0x00002000, 0x00004000,
            0x00008000, 0x00010000, 0x00020000, 0x00040000, 0x00080000, 0x00100000, 0x00200000, 0x00400000, 0x00800000,
            0x01000000, 0x02000000, 0x04000000, 0x08000000, 0x10000000, 0x20000000, 0x40000000, 0x80000000};

    public Mybitmap(long length) {
        this.length = length;
//        (length & 31) > 0说明length的后五位不全为0
        bitsMap = new int[(int) (length >> 5) + ((length & 31) > 0 ? 1 : 0)];
    }

    //    标记
    public void setN(long n) {
        if (n < 0 || n > length) {
            throw new IllegalArgumentException("length value " + n + " is illegal!");
        }

        int index = (int) (n >> 5);
        int offset = (int) n & 31;

        bitsMap[index] |= BIT_VAE[offset];
    }

    //    查看某个数是否存在
    public int isExist(long n) {

        if (n < 0 || n > length) {
            throw new IllegalArgumentException("length value illegal!");
        }

        int index = (int) n >> 5;
        int offset = (int) n & 31;
        int bits = (int) bitsMap[index];

        return (bits & BIT_VAE[offset]) >>> offset;

    }


    public static void main(String[] args) {

        Mybitmap mybitmap = new Mybitmap(1000000000);
        mybitmap.setN(9999999);
        mybitmap.setN(999999);
        mybitmap.setN(3210000);

        System.out.println(mybitmap.isExist(99));
        System.out.println(mybitmap.isExist(9999999));
        System.out.println(mybitmap.isExist(999999));
        System.out.println(mybitmap.isExist(3210000));

    }

}
