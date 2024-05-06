<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showResult.jsp</title>
</head>
<body>
<jsp:useBean id="computer" type="dto.ComputerBean" scope="request"/>
<jsp:getProperty name="computer" property="numberOne" />
<jsp:getProperty name="computer" property="operator" />
<jsp:getProperty name="computer" property="numberTwo" />=
<jsp:getProperty name="computer" property="result" />
</body>
</html>  