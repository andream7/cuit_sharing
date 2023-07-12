<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/3/19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page isErrorPage="true" %>
<%@ page language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>

<%
    String message = request.getParameter("message");
%>

<html>
<head>
    <title>得到结果</title>
</head>
<body>
<h1>结果:</h1>
<p><%= message %></p>
</body>
</html>
