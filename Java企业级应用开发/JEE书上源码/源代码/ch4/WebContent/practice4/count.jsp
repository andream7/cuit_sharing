<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>count.jsp</title>
</head>
<body>
这里是结帐柜台，请确认以下信息。
		<p>
	<%
 	String no = (String) session.getAttribute("no");
 	out.println("您的会员卡号：" + no);
 	Enumeration enumGoods = session.getAttributeNames();
 	out.println("<br>购物车中的商品清单：<br>");
 	while (enumGoods.hasMoreElements()) {
 		String key = (String) enumGoods.nextElement();
 		String good = (String) session.getAttribute(key);
 		//除会员卡号外都是商品
 		if (!(good.equals(no))) {
 			//显示商品
 			out.println("&nbsp;&nbsp;" + good + "<br>");
 			//输出后清除session中的调料
 			session.removeAttribute(key);
 		}
 	}
 %> 
		</p>
		<a href="loginID.jsp"> 欢迎修改会员卡号！</a>
		<a href="food.jsp"> 欢迎来到调料柜台！</a>
</body>
</html>