package com.example.script;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/3 10:11 上午
 */
public class AddAllFilesPath {
    public static void main(String[] args) {
        String src;
        Scanner in = new Scanner(System.in);
        src = in.nextLine();

        File srcFile = new File(src);
//        HashSet<>自动去重
        Set<String> allDir = new HashSet<String>();

        collectAllPath(allDir, srcFile);

        System.out.println();
        System.out.printf("共有%d个文件", allDir.size());
        System.out.println();

        for (String s : allDir) {
            System.out.println(s);
        }
    }

    public static void collectAllPath(Set<String> allDir, File srcFile) {
        if (srcFile.isDirectory()) {
            File[] fs = srcFile.listFiles();
            for (File f : fs) {
                collectAllPath(allDir, f);
            }
        } else {
            if (srcFile.isFile()) {
//                截取文件所在的路径
//                int index = srcFile.toString().lastIndexOf('/');
//                allDir.add(srcFile.toString().substring(0, index));
                allDir.add(srcFile.toString());
            }
        }
    }

    public Set<String> collectAllPath1(Set<String> allDir, File srcFile) {
        if (srcFile.isDirectory()) {
            File[] fs = srcFile.listFiles();
            for (File f : fs) {
                collectAllPath(allDir, f);
            }
        } else {
            if (srcFile.isFile()) {
//                截取文件所在的路径
//                int index = srcFile.toString().lastIndexOf('/');
//                allDir.add(srcFile.toString().substring(0, index));
                allDir.add(srcFile.toString());
            }
        }

        return allDir;
    }
}
