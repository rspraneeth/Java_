package com.rsp.controller;

import com.rsp.model.Student;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email+" "+password);
        Student student = new Student();
        student.setEmail(email);
        student.login();
        String dbEmail = student.getEmail();
        String dbPassword = student.getPassword();
        System.out.println("controller: "+dbEmail+" "+dbPassword);
        if (email.equals(dbEmail) && password.equals(dbPassword)){
            resp.sendRedirect(req.getContextPath()+"/home.html");
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }

    }
}
