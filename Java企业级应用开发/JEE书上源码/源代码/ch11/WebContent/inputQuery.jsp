<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="LightPink">
	<h4>输入查询条件！</h4>
	<form action="selectGoodsServlet" method="post">
	<table border="1">
		<tr>
			<td>商品名称:</td>
			<td><input type="text" name="gname"/></td>
		</tr>		
		<tr>
			<td>商品价格大于:</td>
			<td><input type="text" name="gprice"/></td>
		</tr>			
		<tr>
			<td><input type="submit" value="查询"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</body>
</html>