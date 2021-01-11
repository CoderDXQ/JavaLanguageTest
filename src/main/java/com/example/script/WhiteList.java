package com.example.script;

import com.example.javalanguaguetest.callback.two_writing_method_of_callback2.Li;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/2 11:07 上午
 */

//支持前缀匹配的白名单
public class WhiteList {
    public static void main(String[] args) throws IOException {
        AddAllFilesPath addAllFilesPath = new AddAllFilesPath();

        Scanner in = new Scanner(System.in);
        String src;
        src = in.nextLine();
        File srcFile = new File(src);

        List<String> allFiles = new ArrayList<>();

        allFiles = addAllFilesPath.collectAllPath1(allFiles, srcFile);
        // print(allFiles);

//        读取白名单中的数据
        src = in.nextLine();
//        JDK8中按行读取全部内容的方法
        Path path = Paths.get(src);
        List<String> lines = Files.readAllLines(path);

//        直接在定义时把List转换为Set
        List<String> whitelines = new ArrayList<>(lines);

//        显示处理后的结果
        print(doWhiteList(allFiles, whitelines));

        in.close();
    }


    private static void print(List<String> allFiles) {
        System.out.println();
        System.out.printf("共有%d行信息", allFiles.size());
        System.out.println();
        for (String s : allFiles) {
            System.out.println(s);
        }
    }

    private static List<String> doWhiteList(List<String> allFiles, List<String> whitelines) {

        List<String> adds = new ArrayList<>();
//        内部实现使用的是迭代器，在遍历的时候不能进行删除操作
        for (String all : allFiles) {
            for (String white : whitelines) {
                if (all.startsWith(white)) {
                    adds.add(all);
                    break;
                }
            }
        }

        return adds;
    }
}
