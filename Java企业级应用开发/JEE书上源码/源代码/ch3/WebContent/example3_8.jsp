<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example3_8.jsp</title>
</head>
<body>
	加载computer.jsp页面计算矩形的面积<br><br>
	<jsp:include page="computer.jsp">
		<jsp:param value="10" name="length"/> 
		<jsp:param value="6" name="width"/> 
	</jsp:include>
</body>
</html>
