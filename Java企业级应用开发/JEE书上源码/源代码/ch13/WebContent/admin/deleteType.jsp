<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>删除类型</title>
<link href="admin/css/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className="bgcolor"
		}
		function changeColor1(obj){
			obj.className=""
		}
	</script>
</head>
<body>
	<table border="1">
		<tr>
			<th width="200px">类型ID</th>
			<th width="350px">类型名称</th>
			<th width="300px">类型删除</th>
		</tr>
		<c:forEach var="t" items="${allType}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${t.id}</td>
			<td>${t.typename}</td>
			<td><a href="admin_Type?id=${t.id}&act=delete">删除</a></td>
		</tr>
		</c:forEach> 
	</table>
</body>
</html>