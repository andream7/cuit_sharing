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
    <title>selectAllGoods.jsp</title>
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
	<form action="admin_selectGoods" method="post">
	<br>
	<table style="margin:0 auto">
		<tr>
			<td width="250px">
				商品名称：<input type="text" name="gname" value="${gname1 }">
			</td>
			<td width="200px">  
				商品类型:<select name="typeid">
						<option value="all">全部</option>
						<c:forEach var="gtp" items="${goodsType}">
							<option value="${gtp.id}" <c:if test="${typeid!='all'&&typeid==gtp.id}"> selected </c:if>>${gtp.typename}</option>
						</c:forEach>
				   </select>
				<input type="hidden" name="act" value="condiction"/>   
				<input type="submit" value="条件查询"/>   
			</td>
		</tr>
	</table>
	<br>
	</form>
	<table border="1" style="border-color: PaleGreen">
		<tr>
			<th width="250px">商品ID</th>
			<th width="200px">商品名称</th>
			<th width="200px">商品类型</th>
			<th width="200px">查看详情</th>
		</tr>
		<c:forEach var="g" items="${requestScope.allGoods}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${g.id}</td>
			<td>${g.gname}</td>
			<td>${g.typename}</td>
			<td><a href="admin_detail?gno=${g.id}&act=detail" target="_blank">详情</a></td>
		</tr>
		</c:forEach> 
		<tr>
				<td colspan="4" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<%
						//解决URL不能传中文问题，参见第4章
						String gname1 =(String)request.getAttribute("gname1"); 
						if(gname1 != null){
							gname1 = java.net.URLEncoder.encode(gname1,"utf-8");
							request.setAttribute("gname1",gname1);
						}
					%>
					<c:url var="url_pre" value="admin_selectGoods?act=${act }&&gname1=${gname1}&&typeid=${typeid}">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
					</c:url>
					<c:url var="url_next" value="admin_selectGoods?act=${act }&&gname1=${gname1}&&typeid=${typeid}">
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