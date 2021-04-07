package com.example.writtenexaminationandinterview.DB;

import java.sql.*;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/7 8:54 上午
 */
//jdbc流程
public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//        获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://100.233.63" +
                ".121:3306/cupid?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "AC7cAC75234998");
//        创建statement对象 statement对象负责执行sql语句
        String sql = "select * from post where post_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);
//        向数据库发送sql
        ResultSet resultSet = statement.executeQuery();
//        处理结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("title"));
            System.out.println(resultSet.getString("author"));
        }
//        关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
