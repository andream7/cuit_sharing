<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导出数据</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
		</tr>
	<c:forEach items="${allGoods }" var="goods">
		<tr>
			<td>${goods.id }</td>
			<td>${goods.gname }</td>
			<td>${goods.gprice }</td>
		</tr>
	</c:forEach>
	</table>
	<a href="exportExcelServlet">导出到Excel</a>
</body>
</html>