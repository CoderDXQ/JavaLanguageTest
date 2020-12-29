package com.wgl.cupid;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/15 10:31 上午
 */

//将某个文件夹下所有包含大写的文件名递归地转换成小写，仅适用于Linux系统，MacOS和Windows系统对大小写不敏感，所以不能转换
public class Script {
    public static void main(String[] args) throws IOException {
        String path = "/Users/mango/Desktop/demo";
        Queue<File> queue = new LinkedList<>();
        File rootFile = new File(path);
        queue.add(rootFile);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isFile()) {
                if (file.getName().charAt(0) == '.') {
                    continue;
                }
                if (!judgeLowCase(file.getName())) {
                    String oldName = file.getName();
                    String newName = oldName.toLowerCase();
                    String parentPath = file.getParent();
                    File newFile = new File(parentPath + "/" + newName);
                    Files.copy(file.toPath(), newFile.toPath());
                }
            } else {
                File[] files = file.listFiles();
                for (File f : files) {
                    queue.add(f);
                }
            }
        }
        System.out.println("finish");
    }

    private static boolean judgeLowCase(String fileName) {
        char[] chars = fileName.toCharArray();
        for (char c : chars) {
            if (c == '.') {
                continue;
            }
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
