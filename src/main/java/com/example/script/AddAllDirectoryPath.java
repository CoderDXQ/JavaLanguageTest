package com.example.script;

import java.io.File;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/1 11:54 下午
 */
public class AddAllDirectoryPath {
    public static void main(String[] args) {
        String src;
        Scanner in = new Scanner(System.in);
        src = in.nextLine();

        File srcFile = new File(src);
//        HashSet<>自动去重
        Set<String> allDir = new HashSet<String>();
        collectAllPath(allDir, srcFile);

        System.out.println();
        for (String s : allDir) {
            System.out.println(s);
        }
    }

    //    递归实现
    public static void collectAllPath(Set<String> allDir, File srcFile) {
        if (srcFile.isDirectory()) {
            File[] fs = srcFile.listFiles();
            for (File f : fs) {
                collectAllPath(allDir, f);
            }
        } else {
//            这样设计的话 空文件夹的路径就不会被加进去
            if (srcFile.isFile()) {
//                截取文件所在的路径
                int index = srcFile.toString().lastIndexOf('/');
                allDir.add(srcFile.toString().substring(0, index));
            }
        }
    }
}
