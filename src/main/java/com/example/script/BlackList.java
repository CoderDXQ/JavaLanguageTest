package com.example.script;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/2 11:09 上午
 */
//支持前缀匹配的黑名单
public class BlackList {
    public static void main(String[] args) throws IOException {
        AddAllFilesPath addAllFilesPath = new AddAllFilesPath();

        Scanner in = new Scanner(System.in);
        String src;
        src = in.nextLine();
        File srcFile = new File(src);

        Set<String> allFiles = new HashSet<>();

//        获取待处理的所有文件的路径信息
//        静态方法的调用
//        allFiles=AddAllFilesPath.collectAllPath();
        allFiles = addAllFilesPath.collectAllPath1(allFiles, srcFile);
        // print(allFiles);

//        读取黑名单中的数据
        src = in.nextLine();
//        JDK8中按行读取全部内容的方法
        Path path = Paths.get(src);
        List<String> lines = Files.readAllLines(path);

//        直接在定义时把List转换为Set
        Set<String> blacklines = new HashSet<>(lines);
////        无法进行强制类型转换
//        Set<String> blacklines = (Set<String>) lines;
//        print(blacklines);

//        进行黑名单处理 显示处理后的结果
        print(doBlackList(allFiles, blacklines));

        in.close();
    }

    private static void print(Set<String> allFiles) {
        System.out.println();
        System.out.printf("共有%d行信息", allFiles.size());
        System.out.println();
        for (String s : allFiles) {
            System.out.println(s);
        }
    }

    private static Set<String> doBlackList(Set<String> allFiles, Set<String> blacklines) {

        List<String> deletes = new ArrayList<>();
//        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
        for (String all : allFiles) {
            for (String black : blacklines) {
                if (all.startsWith(black)) {
                    deletes.add(all);
                    break;
                }
            }
        }

//        进行删除操作
        for (String s : deletes) {
            allFiles.remove(s);
        }

        return allFiles;
    }


}
