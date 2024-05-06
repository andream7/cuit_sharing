<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_1.jsp</title>
</head>
<body>
	<form action="getValue.jsp" >
		<input type="text" name="userName"/>
		<input type="submit" value="提交"/>
	</form>  
	<%
		//向request对象中存入test属性
		request.setAttribute("test", "测试");
	%>       
</body>
</html>
