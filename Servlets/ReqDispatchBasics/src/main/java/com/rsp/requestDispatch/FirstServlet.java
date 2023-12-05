package com.rsp.requestDispatch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Control in first Servlet!");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/SecondServlet");
//        requestDispatcher.forward(req,resp); //response is from servlet 2
//        req.getServletContext().getRequestDispatcher("/SecondServlet").forward(req, resp);

//        requestDispatcher.include(req,resp); //response is from servlet 1 only
        req.getServletContext().getRequestDispatcher("/SecondServlet").include(req, resp);

        resp.sendRedirect(req.getContextPath()+"/response1.html");
    }
}
