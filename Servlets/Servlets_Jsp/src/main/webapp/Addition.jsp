<%--
  Created by IntelliJ IDEA.
  User: Praneeth
  Date: 11/30/2023
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition</title>
</head>
  <body bgcolor="#faebd7">
    <%
      int i = Integer.parseInt(request.getParameter("num1"));
      int j = Integer.parseInt(request.getParameter("num2"));
      int k = i+j;
      response.getWriter().println("Result: "+k);
    %>
  </body>
</html>
