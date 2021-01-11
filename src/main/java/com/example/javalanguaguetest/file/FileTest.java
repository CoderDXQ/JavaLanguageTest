package com.example.javalanguaguetest.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/11 4:19 下午
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();

        File file = new File(src);

        exists(file);

        file.delete();

        exists(file);

        file.createNewFile();

        exists(file);
    }

    public static void exists(File file) {

        if (file.exists()) {
            System.out.println(file.toString() + " exists!");
        } else {
            System.out.println(file.toString() + " does not exists!");
        }

    }
}
