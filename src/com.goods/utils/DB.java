package com.goods.utils;

import java.sql.*;

public class DB {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://127.0.0.1:3306/jdblog";
    public static String username = "root";
    public static String password = "root";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,username,password);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void releaseConnection(Connection conn, Statement stat, ResultSet rs){
        try {
            if (conn!=null){
                conn.close();
                conn = null;
            }
            if (stat!=null) {
                stat.close();
                stat = null;
            }
            if (rs!=null){
                rs.close();
                rs = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
