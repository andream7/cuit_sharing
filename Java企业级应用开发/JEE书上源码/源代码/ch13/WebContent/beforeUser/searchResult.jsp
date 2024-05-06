<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>搜索结果</title>
<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="location ared">我的宝贝</div>
		<div class="blank"></div>
		<div>
			<div class="nFlowBox">
				<table style="width:99%; align-content: center;">
					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品图片</th>
						<th>商品价格</th>
						<th>去看看</th>
					</tr>
					<tr>
						<td colspan="5" height="15px"
							style="border: 0 none; background: #FFF"></td>
					</tr>
					<c:forEach var="mf" items="${searchlist}">
						<tr>
							<td bgcolor="#ffffff" align="center">${mf.id}</td>
							<td bgcolor="#ffffff" align="center">${mf.gname}</td>
							<td align="center" bgcolor="#ffffff" height="60px"><img
								style="width: 50px; height: 50px;"
								src="uploadFile/${mf.gpicture}" border="0" title="${mf.gname}" />
							</td>
							<td align="center" bgcolor="#ffffff">${mf.grprice}</td>
							<td align="center" bgcolor="#ffffff"><a
								style="text-decoration: none;" class="f6"
								href="before_detail?gno=${mf.id}">去看看</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
