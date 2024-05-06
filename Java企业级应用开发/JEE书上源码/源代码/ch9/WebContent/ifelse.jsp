<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set value="if" var="firstNumber" scope="request" />
	<c:set value="else" var="secondNumber" scope="request" />
	<c:if test="${firstNumber>secondNumber}">
		最大值为${firstNumber}
</c:if>
	<c:if test="${firstNumber<secondNumber}">
		最大值为${secondNumber}
</c:if>
	<c:choose>
		<c:when test="${firstNumber<secondNumber}">
			最小值为${firstNumber}
		</c:when>
		<c:otherwise>
			最小值为${secondNumber}
		</c:otherwise>
	</c:choose>
</body>

</html>