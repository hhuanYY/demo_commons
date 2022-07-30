package com.utils.开发常用.JDBC;

import java.sql.*;
import java.text.MessageFormat;

public class JdbcDemo {

    /**
     * Statement和PreparedStatement区别
     * 1.执行SQL时,如果无参数时,就可以使用Statement Statement是在执行过程中传入SQL
     * 2.有参数时,就必须使用PreparedStatement执行对象来做SQL预处理操作来防止SQL注入问题
     *      使用PreparedStatement后会将SQL的查询字段固定,导致SQL中的变量只可以使字段查询的值,而不是可以拼接的SQL
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            //1. 获取数据库连接对象
            connection = DriverManager.getConnection("", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
//            preparedStatement.setString(0,"");
            preparedStatement.executeUpdate();

            //2. 创建SQL执行对象
            Statement statement = connection.createStatement();

            //3. 执行SQL
            int i = statement.executeUpdate(MessageFormat.format(" SELECT * FROM t_user WHERE id ={0} ", 0));


        } catch (SQLException e) {
            System.out.println("数据库连接异常: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
}
