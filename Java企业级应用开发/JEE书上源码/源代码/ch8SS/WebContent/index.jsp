<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=response.encodeURL("loginServlet")%>" method="post">  
        	用户名：<input type="text" name="username">  
    		<input type="submit" value="登录">  
    </form>  
</body>
</html>