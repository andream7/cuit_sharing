<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example3_7.jsp</title>
</head>
<body>
	<%
	long i = Math.round(Math.random() * 10);
	if(i%2 == 0){
		System.out.println("获得的整数是偶数，即将跳转到偶数页面evenNumbers.jsp。");
	%>
		<jsp:forward page="evenNumbers.jsp"/>
	<%
		System.out.println("我是偶数尝试一下能看到我吗？");
	}else{
		System.out.println("获得的整数是奇数，即将跳转到奇数页面oddNumber.jsp。");
	%>
	<jsp:forward page="oddNumber.jsp"/>
	<%
		System.out.println("我是奇数尝试一下能看到我吗？");
	} 
	%>
</body>
</html>
