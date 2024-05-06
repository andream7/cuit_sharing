<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_4.jsp</title>
</head>
<body>
	<form action="" method="post">
	<p>我们在学习使用response动态改变contentType属性值
	<p>
		<input type="submit" value="word" name="submit"> 
		<input type="submit" value="excel" name="submit">
		<%
			String str = request.getParameter("submit");
			if ("word".equals(str)) {
				//response调用setContentType方法设置MIME类型为application/msword
				response.setContentType("application/msword");
			} else if ("excel".equals(str)) {
				//response调用setContentType方法设置MIME类型为application/ vnd.ms-excel
				response.setContentType("application/vnd.ms-excel");
			} 
		%>
	</form>
</body>
</html>
