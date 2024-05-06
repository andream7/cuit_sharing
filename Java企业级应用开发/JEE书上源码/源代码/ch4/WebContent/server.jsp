<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>server.jsp</title>
</head>
<body>
<%
	String name=request.getParameter("userName");
	String password=request.getParameter("pwd");
	if("zhangsan".equals(name)&&"123".equals(password)){
		out.print("成功登陆，3秒钟后进入loginSuccess.jsp页面");
		response.setHeader("refresh", "3;url=loginSuccess.jsp");
		return;
	}else{
		response.sendRedirect("login_1.jsp");
	}
%>
</body>
</html>