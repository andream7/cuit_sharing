<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_8_1.jsp</title>
</head>
<body>
	年轻人如何养生呢？<br><br>
	先看看Web服务器给我分配的session对象的ID：
	<%
		String id = session.getId();
	%>
	<br>
	<%=id %>
	<br><br>
	点击链接去<a href="tom/example4_8_2.jsp">吃睡篇</a>看看吧？
</body>
</html>
