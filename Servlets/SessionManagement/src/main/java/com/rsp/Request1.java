package com.rsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Request1")
public class Request1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        if (session.isNew()){
            writer.println("New session created with id "+session.getId());
        } else {
            writer.println("Existing session is being with "+session.getId());
        }
        String fname = req.getParameter("firstName");
        String email = req.getParameter("email");

        session.setAttribute(email, fname);
        session.setMaxInactiveInterval(10); //session expires after 10 seconds

        req.getRequestDispatcher("/Request2").include(req, resp);

        writer.close();
    }
}
