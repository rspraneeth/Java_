package com.example.util;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class JdbcApp {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    int row=0;

    private Connection connection = null;
    String sql = "INSERT INTO userdb.users VALUES(?,?,?,?)";
    private PreparedStatement statement = null;


    public void jdbcRegister(){
        try {
            connection = JdbcUtility.getConn();
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                if (statement != null) {
                    statement.setInt(1, id);
                    statement.setString(2, firstName);
                    statement.setString(3, lastName);
                    statement.setString(4, email);
                    row = statement.executeUpdate();
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtility.close(connection, statement, null);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
