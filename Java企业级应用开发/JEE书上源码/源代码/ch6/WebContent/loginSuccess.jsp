<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
<jsp:useBean id="user" type="dto.User" scope="request"/>
恭喜<jsp:getProperty property="name" name="user"/>登录成功！
</body>
</html>