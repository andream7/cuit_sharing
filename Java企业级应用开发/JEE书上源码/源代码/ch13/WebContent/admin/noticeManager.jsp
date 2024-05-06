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
    <title>noticeManager.jsp</title>
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
  			if(window.confirm("是否删除该公告？")){
  				window.location.href="admin_noticeDetail?act=delete&nid="+id;
  			}
  		}
	</script>
</head>
<body>
	<br>
	<table border="1">
		<tr>
			<th width="200px">公告ID</th>
			<th width="200px">公告标题</th>
			<th width="200px">公告时间</th>
			<th width="250px">查看编辑</th>
		</tr>
		<c:forEach var="n" items="${requestScope.noticeList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.id}</td>
			<td>${n.ntitle}</td>
			<td>${n.ntime}</td>
			<td>
				<a href="admin_noticeDetail?nid=${n.id}&act=detail" target="_blank">详情</a>&nbsp;&nbsp;
				<a href="javaScript:checkDel('${n.id}')">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr><td colspan="4">&nbsp;</td></tr> 
		<tr>
			<td colspan="4"><a href="admin/addnotice.jsp">添加公告</a></td>
		</tr> 
	</table>
</body>
</html>