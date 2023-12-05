package com.rsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Request2")
public class Request2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Control in 2nd servlet");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        if (session != null) {
            Enumeration<String> en = session.getAttributeNames();
            while (en.hasMoreElements()) {
                String name = en.nextElement();
                Object value = session.getAttribute(name);
                writer.println(name + " : " + value);
                writer.println(session.getCreationTime());
            }

        } else {
            writer.println("Session info is not available for the user");
        }

        writer.close();
    }
}
