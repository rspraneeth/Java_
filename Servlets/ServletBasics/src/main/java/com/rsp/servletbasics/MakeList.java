package com.rsp.servletbasics;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list")
public class MakeList extends HttpServlet {
    public MakeList() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>List</title></head>\n" +
                "<body bgcolor=\"#FDF5E6\">\n" +
                "<h1>List</h1>\n" +
                "<ul>\n" +
                "  <li>" + Math.random() + "</li>\n" +
                "  <li>" + Math.random() + "</li>\n" +
                "  <li>" + Math.random() + "</li>\n" +
                "  <li>" + Math.random() + "</li>\n" +
                "</ul>\n" +
                "</BODY></HTML>");
    }
}
