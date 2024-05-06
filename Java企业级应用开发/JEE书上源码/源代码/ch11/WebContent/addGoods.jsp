<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goodsServlet" method="post">
	<table border="1">
		<tr>
			<td>商品名称:</td>
			<td><input type="text" name="gname"/></td>
		</tr>
		<tr>
			<td>商品价格:</td>
			<td><input type="text" name="gprice"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="添加"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</body>
</html>