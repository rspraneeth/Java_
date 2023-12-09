package com.rsp.controller;

import com.rsp.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Objects.equals(name, "") || Objects.equals(email, "") || Objects.equals(password, "")){
            resp.sendRedirect(req.getContextPath()+"/register.html");
        }else {
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);
            student.setPassword(password);
            int row = student.register();
            if (row != 0) resp.sendRedirect(req.getContextPath()+"/login.html");
            else resp.sendRedirect(req.getContextPath()+"/register.html");
        }
    }
}
