<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food.jsp</title>
</head>
<body>
<form action="" method="post" name="form">
			这里是调料柜台，请选择您要购买的调料：
			<br />
			<input type="checkbox" name="food" value="调和油">
			调和油
			<input type="checkbox" name="food" value="强化盐">
			强化盐
			<input type="checkbox" name="food" value="多维醋">
			多维醋
			<input type="checkbox" name="food" value="绿色调料">
			绿色调料
			<br />
			<input type="submit" value="购物" name="submit">
			<p>
				<a href="loginID.jsp"> 欢迎修改会员卡号！</a>
				<a href="count.jsp"> 欢迎查看购物车！</a>
			</p>
			<%
				request.setCharacterEncoding("utf-8");
				String goods[] = request.getParameterValues("food");
				if (goods != null && goods.length != 0) {
					for (int i = 0; i < goods.length; i++) {
						session.setAttribute(goods[i], goods[i]);
					}
				}
			%>
</form>
</body>
</html>