<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    <title>订单管理</title>
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
		function checkDel(id){
  			if(window.confirm("是否删除该订单？")){
  				window.location.href="admin_orderManager?act=delete&ordersn="+id;
  			}
  		}
	</script>
</head>
<body>
	<br>
	<table border="1">
		<tr>
			<th width="150px">订单编号</th>
			<th width="150px">用户E-mail</th>
			<th width="100px">订单金额</th>
			<th width="100px">订单状态</th>
			<th width="150px">订单日期</th>
			<th width="100px">操作</th>
		</tr>
		<c:forEach var="n" items="${orderList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.id}</td>
			<td>${n.bemail}</td>
			<td>${n.amount}</td>
			<td><c:if test="${n.status == 0}" >未付款</c:if><c:if test="${n.status == 1}" >已付款</c:if></td>
			<td>${n.orderdate}</td>
			<td>
				<c:if test="${n.status == 0}" >
					<a href="javaScript:checkDel('${n.id}')">删除</a>
				</c:if>
				&nbsp;
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>