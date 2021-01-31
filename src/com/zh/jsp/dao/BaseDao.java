package com.zh.jsp.dao;

import java.sql.*;

/**
 * 数据访问层基类
 */
public abstract class BaseDao {
    /**
     * 获取MySQL数据库连接
     *
     * @return
     */
    public Connection getMysqlConnection() {
        try {
            String user = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3305/mysql?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库连接资源
     *
     * @param conn
     * @param s
     * @param rs
     */
    public void closeAll(Connection conn, Statement s, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
