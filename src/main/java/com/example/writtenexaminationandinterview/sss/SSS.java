package com.example.writtenexaminationandinterview.sss;

/**
 * @author duanxiangqing
 * @date 2021/5/25
 */
//String StringBuilder StringBuffer的区别
//使用StringBuilder或者StringBuffer拼接会比"+"快百倍
public class SSS {

    public static void main(String[] args) {

//        String s = new String("   aaa   ");
//        一般用来作字符串常量  放在字符串常量池中
        String s = "   aaa   ";

//        有返回值而不是直接改变s的值
        s.trim();

        System.out.println(s);
        System.out.println(s.trim() + s.trim());

        System.out.println();
        System.out.println();

//        线程不安全
        StringBuilder sb = new StringBuilder();

        sb.append("123456789");
        sb.reverse();
        System.out.println(sb);

        sb.insert(3, '$');
        System.out.println(sb);

        sb.deleteCharAt(0);
        System.out.println(sb);

        System.out.println(sb.toString());


        System.out.println();
        System.out.println();


//        线程安全
        StringBuffer sbf = new StringBuffer();

        sbf.append("1234567890");
        System.out.println(sbf);
        sbf.reverse();
        System.out.println(sbf);


    }

}
