package com.example.javalanguaguetest.runtimetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/16 1:11 上午
 */
public class RuntimeTest1 {
    public static void main(String[] args) {

        try {
            Runtime rt = Runtime.getRuntime();//得到这个对象
            Process proc = rt.exec("javac");//新建一个进程执行命令

            InputStream stderr = proc.getErrorStream();//进程的错误输入流
            InputStreamReader isr = new InputStreamReader(stderr);//负责读入的对象
            BufferedReader br = new BufferedReader(isr);//负责缓存的对象

            String line = null;
            System.out.println("<error></error>");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("");

            int exitVal = proc.waitFor();//waitFor方法会一直阻塞直到外部命令执行结束，然后返回外部命令执行的结果
            System.out.println("Process exitValue: " + exitVal);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
