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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = checkVal(req.getParameter("firstName"), "Missing first name");
        String lastName = checkVal(req.getParameter("lastName"), "Missing last name");
        String emailAddress = checkVal(req.getParameter("emailAddress"), "Missing email");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(ServletUtilities.headWithTitle("User")+
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\"> User </H1>\n" +
                "<UL>\n" +
                "  <LI><B>Id</B>: " + id + "\n" +
                "  <LI><B>First Name</B>: " + firstName + "\n" +
                "  <LI><B>Last Name</B>: " + lastName + "\n" +
                "  <LI><B>Email address</B>: " + emailAddress + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
        System.out.println("details displayed");


        try (Connection connection = JdbcUtility.getConn()){
            System.out.println("trying to insert into db...");
            String sql = "INSERT INTO userdb.users VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, emailAddress);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("some error");
            System.out.println(e.getMessage());
        }

    }

    protected String checkVal(String orig, String replacement){
        if(orig == null || orig.trim().isEmpty()){
            return "<font color = red><b>"+replacement+"</b></font>";
        }
        else return orig;
    }
}