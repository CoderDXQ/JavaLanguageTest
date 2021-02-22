package com.example.script;

import java.io.File;
import java.io.IOException;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/22 10:20 下午
 */
public class CreateBlankHead {

    public static void main(String[] args) throws IOException {

//        ？？？ NewHeadByDTS文件夹文件夹要在程序开始时创建  否则在新建了头文件之后在编译命令中找不到还要重新预处理整个工程
//        ???可能还要处理args[0]后面的"/"
//        if (args[0].endsWith("/")) {
//            args[0] = args[0].substring(0, args[0].length() - 1);
//        }


//        项目地址 新的空头文件放在项目根目录的NewHeadByDTS文件夹之下
//        这里要拆出去一个函数
        String projectpath = "/Users/duanxiangqing/Desktop/TestBlankHead" + "/NewHeadByDTS/";
        File newBlankDir = new File(projectpath);
        if (!newBlankDir.exists()) {
            newBlankDir.mkdir();
        } else {
            System.out.println(projectpath + " 文件夹已经存在");
        }

//        ???这里的引号可能需要处理一下  看看从msg里读出来是什么样的
        String msg = "/home/dtslinux/桌面/blankhead/blankheadtest.cpp:2:10: fatal error: dtsblankhead.h: 没有那个文件或目录 #include \"qwq/qwq/dtsblankhead.h\"          ^~~~~~~~~~~~~~~~compilation terminated.\n";

//        暂时用这个来处理
        Integer index1 = 0;
        Integer index2 = 0;

//        每次报错就只报一个缺失的头文件 否则的话需要改逻辑
        if (msg.contains("#include <")) {
            index1 = msg.indexOf("#include <");
            while (msg.charAt(index1) != '<') {
                index1++;
            }
            index1++;

            index2 = index1;
            while (msg.charAt(index2) != '>') {
                index2++;
            }
        }

        if (msg.contains("#include \"")) {
            index1 = msg.indexOf("#include \"");
            while (msg.charAt(index1) != '\"') {
                index1++;
            }
            index1++;

            index2 = index1;
            while (msg.charAt(index2) != '\"') {
                index2++;
            }
        }


//        获得要创建的空头文件的路径
        String blankHead = msg.substring(index1, index2);
        String creatpath = projectpath + blankHead;

        //创建相对路径的头文件所依赖的文件夹
        if (blankHead.contains("/")) {
            Integer index3 = blankHead.lastIndexOf("/");
            String relativePath = blankHead.substring(0, index3);
            System.out.println("空头文件的相对路径" + relativePath);

            File relativeDir = new File(projectpath + relativePath);
            if (!relativeDir.exists()) {
                relativeDir.mkdirs();
                System.out.println(relativeDir + "文件夹被创建");
            } else {
                System.out.println(relativeDir + "已经存在");
            }
        }


        System.out.println("空头文件绝对路径：" + creatpath);

        File newBlankHead = new File(creatpath);
        if (!newBlankHead.exists()) {
            newBlankHead.createNewFile();
        } else {
            System.out.println(creatpath + "已经存在！");
        }

//        ？？？最后还要重新执行一下编译命令
//        ？？？ 还要设置成一个开关

    }
}
