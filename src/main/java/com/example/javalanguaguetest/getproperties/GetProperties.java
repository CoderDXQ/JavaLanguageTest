package com.example.javalanguaguetest.getproperties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/4 12:35 上午
 */
//读取配置文件的方法
public class GetProperties {
    public static void main(String[] args) {
        String driver;
        String url;
        String user;
        String password;

        try {
            //使用Properties处理流R
            //使用load()方法加载指定的流
            Properties props = new Properties();
            //直接使用绝对路径
            Reader is = new FileReader("/Users/ddd/Desktop/java语法/src/main/java/com/example/javalanguaguetest/getproperties/db.properties");
            props.load(is);

            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
    }
}
