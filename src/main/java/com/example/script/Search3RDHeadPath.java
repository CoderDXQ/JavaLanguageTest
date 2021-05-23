package com.example.script;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duanxiangqing
 * @date 2021/5/8
 */
public class Search3RDHeadPath {

    //    传入一个txt文件的绝对路径  这个txt文件存放了
    public static List<String> Search3RDHeadPathByARGS(String path) throws IOException {

        //从path变量读文件
        Path pathOf3rd = Paths.get(path);
        List<String> lines = Files.readAllLines(pathOf3rd);

        List<File> files = new ArrayList<>();

        for (String line : lines) {
            files.add(new File(line));
        }

        // 处理文件中的路径得到各个文件树的路径 需要使用set去重

        Set<String> set = new HashSet<>();

        for (File line : files) {
            collectAllPath(set, line);
        }

        //得到的Set中的数据添加到DTS的编译命令中
        //???如何插入  插入在哪

        for (String s : set) {
            System.out.println(s);
        }


        return null;
    }

    //   ？？？ 这个可以直接复用
//      这里可能还是需要添加全部的路径 后续再看是否需要修改
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

    public static void main(String[] args) throws IOException {

        Search3RDHeadPathByARGS("/Users/duanxiangqing/Desktop/a.txt");

    }

}
