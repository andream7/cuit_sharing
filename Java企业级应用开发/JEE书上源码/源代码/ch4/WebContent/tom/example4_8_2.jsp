<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_8_2.jsp</title>
</head>
<body>
	欢迎您进入养生之<font size=5>吃睡篇</font>！<br><br>
	先看看Web服务器给我分配的session对象的ID：
	<%
		String id = session.getId();
	%>
	<br>
	<%=id %>
	<br><br>
	吃，不忌嘴，五谷杂粮、蔬菜水果通吃不挑食<br>
	睡，早睡早起不熬夜<br><br>
	点击链接去<a href="../cat/example4_8_3.jsp">运动篇</a>看看吧？
</body>
</html>
