package com.example.registrationjdbc;

import java.io.*;

import com.example.util.JdbcApp;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class Register extends HttpServlet {

    public Register() {
        super();
        System.out.println("Register obj is created");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
//        PrintWriter writer = resp.getWriter();

        JdbcApp app = new JdbcApp();
        app.setId(id);
        app.setFirstName(firstName);
        app.setLastName(lastName);
        app.setEmail(email);

        app.jdbcRegister();
        int row = app.getRow();

//        writer.println("<html> <head><title>User App</title></head><body style=\"background-color: azure\"><h1><marquee>Hi This is RSP.</marquee></h1>");

        if (row!=0)
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
//            writer.println("<h1>User Registered</h1>");
        else resp.sendRedirect(req.getContextPath()+"/fail.jsp");
//            writer.println("<h1>Failed to Register</h1>");

//        writer.println("</body></html>");
    }
}