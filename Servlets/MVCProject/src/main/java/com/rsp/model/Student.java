package com.rsp.model;

import com.rsp.util.JdbcUtility;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class Student {
    private String name;
    private String email;
    private String password;
    private Connection connection;
    private PreparedStatement statement;
    private int row;

    public int register(){
        try {
            connection = JdbcUtility.getConn();
            String query = "insert into schema1.studentportal (`name`, `email`, `password`) values(?,?,?)";
            if (connection != null){
                statement = connection.prepareStatement(query);
                if (statement != null){
                    statement.setString(1, name);
                    statement.setString(2, email);
                    statement.setString(3, password);
                    row = statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JdbcUtility.close(connection, statement);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return row;
    }
}
