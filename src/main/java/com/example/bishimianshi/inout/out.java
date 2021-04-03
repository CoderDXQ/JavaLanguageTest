package com.example.bishimianshi.inout;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/3 9:19 下午
 */
public class out {

    /**
     * 说明：
     * %d 整数
     * %8d 整数 右对齐 输出宽度为8
     * %-8d 整数 左对齐 输出宽度为8
     * <p>
     * %8f 浮点数 输出宽度为8 左对齐右边填充
     * %.5f 浮点数 左对齐 精确到小数点后5位
     * %16.3f浮点数 精确到小数点后三位 右对齐 输出宽度为16
     * <p>
     * <p>
     * 注意:必须使用printf
     *
     * @param args
     */

    //    java格式化输出
    public static void main(String[] args) {

        System.out.println("整数相关：");
        System.out.printf("%d\n", 5);
//        右对齐
        System.out.printf("%8d\n", 5);
        System.out.printf("%-8d\n", 5);
        System.out.println();

        System.out.println("浮点数相关：");
//        左对齐右边填充
        System.out.printf("%8f\n", 5.5);
//        左对齐右边填充
        System.out.printf("%.5f\n", 5.5);
//        右对齐
        System.out.printf("%16.3f\n", 5.5);
//        左对齐 小数点后填充补足3位即可
        System.out.printf("%-16.3f\n", 5.5);
        System.out.printf("%f; %f;%n", -756.403f, 7464.232641d);

        System.out.println();


        System.out.println("常用：");
//        必须使用printf
//        总长度是10 右对齐 小数点后5位
        System.out.printf("%+10.5f\n", 3.14);
        System.out.println();

//        小数点后5位 左对齐
        System.out.printf("%.5f\n", 3.14);
        System.out.println();


//        多种数据类型输出
        System.out.println("多种类型输出：");
        char chTemp = 'a';
        System.out.printf("%s%c:\n十进制:%d\n十六进制:%x\n", "输出字符型变量", chTemp, (int) chTemp, (int) chTemp);
        System.out.println();

        System.out.println("科学记数法：");
        System.out.printf("%e\n", -45.5677f);
        System.out.printf("%e\n", -45.5677d);
//        大写
        System.out.printf("%E\n", -45.5677f);
        System.out.printf("%E\n", -45.5677d);
        System.out.println();

        System.out.println("字符串相关：");
//        转换为大写
        System.out.printf("%S\n", "asd");
        System.out.println();

        System.out.println("boolean类型相关：");
        System.out.printf("true=%b\n", true);
        System.out.println();

        System.out.println("整数相关：");
//        十进制
        System.out.printf("%d; %d; %n", -500, 2343L);
//        八进制
        System.out.printf("%o; %o; %n", -500, 2343L);
//        十六进制
        System.out.printf("%x; %x; %n", -500, 2343L);
//        十六进制大写
        System.out.printf("%X; %X; %n", -500, 2343L);

        System.out.println();


    }

}
