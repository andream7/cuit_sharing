<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="listener.MySeesionListener" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	test.jsp
	<%
		MySeesionListener msl = new MySeesionListener();
		msl.setName("测试session内监听器");
		//绑定到session
		session.setAttribute("msl", msl);
		//从session中移除
		session.removeAttribute("msl");
	%>
</body>
</html>