<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
<%= request.getParameter("user")%> 
<br>
<%= request.getParameter("pwd")%>
</body>
</html>