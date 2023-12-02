package com.rsp.forms;

import com.rsp.coreservlets.ServletUtilities;
import com.rsp.utilities.JdbcUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/users")
public class DisplayUsers extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try (Connection connection = JdbcUtility.getConn()) {
            String sql = "SELECT * FROM userdb.users";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                out.println(ServletUtilities.headWithTitle("User List") +
                        "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                        "<H1 ALIGN=\"CENTER\"> User List </H1>\n" +
                        "<UL>\n");

                while (resultSet.next()) {
                    out.println("  <LI><B>First Name</B>: " + resultSet.getString("first_name") + "\n" +
                            "  <LI><B>Last Name</B>: " + resultSet.getString("last_name") + "\n" +
                            "  <LI><B>Email address</B>: " + resultSet.getString("email") + "\n");
                }

                out.println("</UL>\n" +
                        "</BODY></HTML>");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
