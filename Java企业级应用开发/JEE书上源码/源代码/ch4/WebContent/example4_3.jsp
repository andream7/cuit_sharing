<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_3.jsp</title>
</head>
<body>
	<%
		//从请求域中获取属性errorMsg的错误消息
		String error = (String)request.getAttribute("errorMsg");
		if(error != null){
			out.print("<font color='red'>" + error + "</font>");
		}
	%>
	<form action="example4_3_1.jsp">
		输入一个整数求平方：
		<input type="text" name="mynumber">
		<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>