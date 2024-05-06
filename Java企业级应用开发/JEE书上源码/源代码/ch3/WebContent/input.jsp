<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
使用include动作标记加载first.jsp页面，画出一个表格。<br>
<jsp:include page="first.jsp">
	<jsp:param value="10" name="row"/>
	<jsp:param value="20" name="col"/>
</jsp:include>
<br>
使用include动作标记加载second.jsp页面，求两个最大正整数的公约数。<br>
<jsp:include page="second.jsp">
	<jsp:param value="64" name="firstNumber"/>
	<jsp:param value="48" name="secondNumber"/>
</jsp:include>
</body>
</html>