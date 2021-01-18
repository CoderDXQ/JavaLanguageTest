package com.example.javalanguaguetest.reflection.WithProperties;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/1/18 10:50 下午
 */
public class WithProperties {
    //    抛出的异常太多，可以用这些异常的根类代替
//    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
    public static void main(String[] args) throws Exception {
        //        通过配置文件来改变获得的具体的类名的值，提高代码的适用性
        Class stuClass = Class.forName(getValue("className"));
        Method m = stuClass.getMethod(getValue("methodName"));
//        调用方法 m是show方法，invoke中指定一个类的实例来执行这个方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();
//        注意这里的路径的形式
        try (FileReader in = new FileReader("src/main/java/com/example/javalanguaguetest/reflection/WithProperties/pro.txt")) {
            pro.load(in);
            in.close();
        }
        return pro.getProperty(key);
    }
}
