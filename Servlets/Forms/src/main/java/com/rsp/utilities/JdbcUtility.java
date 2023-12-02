package com.rsp.utilities;

import java.sql.*;

public class JdbcUtility {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() throws SQLException {
        System.out.println("Connected to db");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "projectK");
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (conn!=null) conn.close();
        if(stmt!=null) stmt.close();
        if(rs!=null) rs.close();
    }
}
