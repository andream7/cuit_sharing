<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" info="page内置对象测试"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example4_13.jsp</title>
</head>
<body>
	使用this获取本页面的说明信息：<%=this.getServletInfo() %><br>
	使用page对象获取本页面的说明信息：<%=((HttpJspPage)page).getServletInfo() %>
</body>
</html>