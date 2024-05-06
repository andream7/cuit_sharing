<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out99</title>
</head>
<body>
	九九乘法表
	<table border=1>
		<c:forEach var="i" begin="1" end="9">
			<tr>
				<c:forEach var="j" begin="1" end="${i}">
					<td>${i} * ${j} = ${i * j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>