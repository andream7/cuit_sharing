<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
		<tr>
			<th>Value</th>
			<th>Square</th>
			<th>Index</th>
		</tr>
		<c:forEach var="x" varStatus="status" begin="0" end="10" step="2">
			<tr>
				<td>${x}</td>
				<td>${x * x}</td>
				<td>${status.index}</td>
			</tr>
		</c:forEach>
</table>

</body>
</html>