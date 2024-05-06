<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	 	<tr>
			<td colspan="3" align="right">
				&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
				第${pageCur}页&nbsp;&nbsp;
				<c:url var="url_pre" value="selectGoodsByPageServlet">
					<c:param name="pageCur" value="${pageCur - 1 }"/>
				</c:url>
				<c:url var="url_next" value="selectGoodsByPageServlet">
					<c:param name="pageCur" value="${pageCur + 1 }"/>
				</c:url>
				<!-- 第一页没有上一页 -->
				<c:if test="${pageCur != 1 }">
					<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${pageCur != totalPage && totalPage !=0 }">
					<a href="${url_next}">下一页</a>
				</c:if>
			</td>
		</tr>  
	</table>
</body>
</html>
