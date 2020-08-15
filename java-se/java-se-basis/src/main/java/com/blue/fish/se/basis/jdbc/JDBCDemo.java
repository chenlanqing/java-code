package com.blue.fish.se.basis.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class JDBCDemo {

    public static void main(String[] args) throws Exception {
//        DriverManager.registerDriver(new Driver());

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        String userName = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, userName, password);

        String sql = "select ename from t_emp where sal < ? and job = ? ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, "1500");
        ps.setObject(2, "SALESMAN");

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }

        connection.close();
    }
}
