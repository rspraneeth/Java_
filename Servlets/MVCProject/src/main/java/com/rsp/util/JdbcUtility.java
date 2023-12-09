package com.rsp.util;

import java.sql.*;

public class JdbcUtility {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schema1", "root", "projectK");
    }

    public static void close(Connection conn, Statement stmt) throws SQLException {
        if (conn!=null) conn.close();
        if(stmt!=null) stmt.close();

    }
}
