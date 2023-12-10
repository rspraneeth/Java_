package com.rsp.model;

import com.rsp.util.JdbcUtility;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Student {
    private String name;
    private String email;
    private String password;
    private Connection connection;
    private PreparedStatement statement;
    private int row;
    private ResultSet rs;

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

    public void login(){
        try {
            connection = JdbcUtility.getConn();
            String query = "select email, password from schema1.studentportal  where email=?";
            if (connection!=null){
                statement = connection.prepareStatement(query);
                if (statement!=null){
                    statement.setString(1, email);
                    rs = statement.executeQuery();
                    while (rs.next()){
                        System.out.println("in while loop of result set");
                        email = rs.getString("email");
                        password = rs.getString("password");
                        System.out.println("model: "+email+" "+password);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
