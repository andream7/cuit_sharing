<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="${param.data}" default="没有数据" />
<br>
<c:out value="${param.nothing}" />
<br>
<c:out value="这是一个字符串" />
</body>
</html>