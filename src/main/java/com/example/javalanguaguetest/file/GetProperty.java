package com.example.javalanguaguetest.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/2/6 2:47 下午
 */
public class GetProperty {
    public static void main(String[] args) {
//        工程根路径
        System.out.println("System.getProperty(" + "\"" + "user.dir" + "\"" + ")  " + System.getProperty("user.dir"));

        File directory = new File("abc");

        try {
//            绝对路径
            System.out.println("directory.getAbsolutePath()  " + directory.getAbsolutePath());
//            标准路径
            System.out.println("directory.getCanonicalPath()  " + directory.getCanonicalPath());
            System.out.println("directory.getPath()  " + directory.getPath());
            System.out.println("directory.getParentFile())  " + directory.getParentFile());
            System.out.println("directory.getTotalSpace()  " + directory.getTotalSpace());
            System.out.println("directory.getParent()  " + directory.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            directory.delete();
        }
        System.out.println();


        File directory1 = new File(".");
        try {
//            绝对路径
            System.out.println("directory.getAbsolutePath()  " + directory1.getAbsolutePath());
//            标准路径
            System.out.println("directory.getCanonicalPath()  " + directory1.getCanonicalPath());
            System.out.println("directory.getPath()  " + directory1.getPath());
            System.out.println("directory.getParentFile())  " + directory1.getParentFile());
            System.out.println("directory.getTotalSpace()  " + directory1.getTotalSpace());
            System.out.println("directory.getParent()  " + directory1.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            directory1.delete();
        }
        System.out.println();


        File directory2 = new File("..");
        try {
//            绝对路径
            System.out.println("directory.getAbsolutePath()  " + directory2.getAbsolutePath());
//            标准路径
            System.out.println("directory.getCanonicalPath()  " + directory2.getCanonicalPath());
            System.out.println("directory.getPath()  " + directory2.getPath());
            System.out.println("directory.getParentFile())  " + directory2.getParentFile());
            System.out.println("directory.getTotalSpace()  " + directory2.getTotalSpace());
            System.out.println("directory.getParent()  " + directory2.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            directory2.delete();
        }

        File directory3 = new File("../..");
        try {
//            绝对路径
            System.out.println("directory.getAbsolutePath()  " + directory3.getAbsolutePath());
//            标准路径
            System.out.println("directory.getCanonicalPath()  " + directory3.getCanonicalPath());
            System.out.println("directory.getPath()  " + directory3.getPath());
            System.out.println("directory.getParentFile())  " + directory3.getParentFile());
            System.out.println("directory.getTotalSpace()  " + directory3.getTotalSpace());
            System.out.println("directory.getParent()  " + directory3.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            directory3.delete();
        }


    }
}
