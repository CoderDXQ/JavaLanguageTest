package com.example.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试DTS的jar包应该放在什么地方 具体的需要发个post请求测试一下
 */
public class FindDTSStartPath {


    public static void main(String[] args) throws IOException {

//        linux下的具体用法看DTS源代码
        String[] cmd = new String[]{"/bin/sh", "-c", "pwd"};

//        开一个进程执行
        Process ps = Runtime.getRuntime().exec(cmd);

        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));

        StringBuffer sb = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        String result = sb.toString();

        System.out.println(result);


    }

}
