package com.example.servlet2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/reg")
public class Register extends HttpServlet {

    public Register() {
        super();
        System.out.println("Register obj is created");
    }
    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String city = req.getParameter("ucity");
        String phone = req.getParameter("uphone");
        PrintWriter writer = resp.getWriter();
        writer.println("<html> <head><title>First App</title></head><body style=\"background-color: azure\"><h1><marquee>Hi This is RSP.</marquee></h1>");
        writer.println("<table>");
        writer.println("<tr><th>NAME</th> <th>CITY</th> <th>PHONE</th></tr>");
        writer.println("<tr><td>" + name + "</td><td>" + city + "</td><td>" + phone + "</td></tr>");
        writer.println("</table>");
        writer.println("</body></html>");
    }

    public void destroy() {
    }
}