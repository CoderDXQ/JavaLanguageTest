package com.example.javalanguaguetest.runtimetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/10/15 10:03 上午
 */

@Slf4j  //加了此注解可以直接使用log.info()打印日志
public class RuntimeTest {
    //  private final static Logger logger = LoggerFactory.getLogger(RuntimeTest.class);
    public static void main(String[] args) {

        try {
            //单纯的这两句不会输出执行结果
            String[] cmd = new String[]{"/bin/sh", "-c", "ls -l"};//前两个字符串是linux下的必有函数 这个命令在运行时不会造成阻塞 不需要使用waitFor()方法
          //  String cmd="/bin/sh -c ls -l"; //必须使用数组来执行
            Process ps = Runtime.getRuntime().exec(cmd);

            //拿取结果
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));//获取子进程的输入流
            StringBuffer sb = new StringBuffer();//缓冲池
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");//读入池中
            }
            String result = sb.toString();

            log.info(result);

        } catch (IOException e) {
            log.error("-------error-------");
            e.printStackTrace();//输出调用线索
        }
    }
}
