<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_8_3.jsp</title>
</head>
<body>
	欢迎您进入养生之<font size=5>运动篇</font>！<br><br>
	先看看Web服务器给我分配的session对象的ID：
	<%
		String id = session.getId();
	%>
	<br>
	<%=id %>
	<br><br>
	动，坚持运动——这一点年轻人很多都做不好，<br>高兴起来就拼命打球，懒起来拼命睡觉，不好！<br>
	总之，生活规律化，坚持长期运动<br><br>
	点击链接去<a href="../example4_8_1.jsp">首页</a>看看吧？
</body>
</html>
