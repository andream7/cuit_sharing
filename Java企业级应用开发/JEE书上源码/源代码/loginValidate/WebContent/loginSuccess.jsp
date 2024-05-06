<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
	<%
	String username=(String)session.getAttribute("user");
	%>
	恭喜<%=username %>登录成功！
</body>
</html>
