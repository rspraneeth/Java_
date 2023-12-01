package com.rsp.servletbasics;

// Create a servlet that uses a loop to output an HTML table with 25 rows and 10 columns. For
//instance, each row could contain “RowX, Col1”, “RowX Col2”, and “RowX Col3”, where X is the
//current row number.

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/table")
public class MakeTable extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>Table</title></head>\n" +
                "<body bgcolor=\"#FDF5E6\">\n" +
                "<h1>Table</h1>\n" +
                "<table border=\"1\">\n");
        for (int i = 1; i <= 25; i++) {
            writer.println("<tr>");
            for (int j = 1; j <= 10; j++) {
                writer.println("<td>Row" + i + ", Col" + j + "</td>");
            }
            writer.println("</tr>");
        }
        writer.println("</table>\n" +
                "</body></html>");
    }
}
