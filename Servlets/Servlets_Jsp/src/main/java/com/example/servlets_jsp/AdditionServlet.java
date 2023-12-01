package com.example.servlets_jsp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addition")
public class AdditionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));
        int k = i + j;
        PrintWriter out = response.getWriter();
        out.println("<html>\n"+
                "<head><title>Addition Page</title></head>\n"+
                "<body bgcolor='cyan'><h1>Output is "+k+"</h1></body></html>");
    }
}
