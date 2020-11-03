package com.example.javalanguaguetest.jdbctest;

import java.sql.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/11/3 10:36 下午
 */
public class JdbcTest {
    public static void main(String[] args) {
        //Statement
        try {
            //要提前导入mysql-connector-java的jar包 手动或者使用maven
            String name = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/etc?characterEncoding=UTF-8&serverTimezone=UTC";
            String username = "root";
            String password = "dxq5522565";

            //加载驱动类
            Class.forName(name);
            //建立连接
            Connection con = DriverManager.getConnection(url, username, password);
            //创建操作声明 用于执行静态sql语句并返回它所生成结果的对象
            Statement stat = con.createStatement();

            //插入操作
            stat.executeUpdate("insert into cartype (id,car_type,description) values(333,6,'7')");

            //查询操作
            ResultSet rs = stat.executeQuery("select * from userlist");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t" + rs.getString("user_name") + "\t" + rs.getString("user_number"));
            }
            rs.close();

            //一个stat同时只能存放一个查询结果 不允许交叉使用 因为Statement接口的所有执行方法都会隐式地关闭
            ResultSet rc = stat.executeQuery("select  * from cartype");
            while (rc.next()) {
                System.out.println(rc.getString("id") + "\t" + rc.getString("car_type") + "\t" + rc.getString("description"));
            }
            rc.close();

            //关闭连接
            stat.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
