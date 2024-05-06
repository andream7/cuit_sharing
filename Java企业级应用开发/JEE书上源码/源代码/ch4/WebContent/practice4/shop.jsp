<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop.jsp</title>
</head>
<body>
<%
				//获取并存储会员卡号
				String no = request.getParameter("no");
				if (no == null) {
					no = "";
				} else {
					session.setAttribute("no", no);
				}
			%>

<a href="food.jsp">这里是调料柜台，欢迎选购您喜欢的调料。</a><br>
<a href="loginID.jsp"> 欢迎修改会员卡号！</a>
</body>
</html>