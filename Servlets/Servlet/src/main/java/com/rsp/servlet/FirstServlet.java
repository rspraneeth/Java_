package Servlet.src.main.java.com.rsp.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet  extends HttpServlet {

    static {
        System.out.println("Servlet is loaded.");
    }
    public FirstServlet(){
        super();
        System.out.println("Servlet is instantiated.");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init is initialized");
    }

    public void destroy(){
        System.out.println("At the end to close the app.");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in doGet(), method to handle request and response.");
        PrintWriter writer = response.getWriter();
        writer.println("<html> <head><title>First App</title></head><body style=\"background-color: azure\"><h1><marquee>Hi This is RSP.</marquee></h1></body></html>");
    }
}
