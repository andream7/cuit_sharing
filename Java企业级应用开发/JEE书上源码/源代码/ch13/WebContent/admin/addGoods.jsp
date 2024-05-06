<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>addGoods.jsp</title>
<link href="admin/css/common.css" type="text/css" rel="stylesheet">
</head>    
<body>
	<form action="admin_addGoods?act=add" method="post" enctype="multipart/form-data">
		<table border=1 style="border-collapse: collapse">
			<caption>
				<font size=4 face=华文新魏>添加商品</font>
			</caption>
			<tr>
				<td>商品名称<font color="red">*</font></td>
				<td><input type="text" name="gname" /> 
				</td>
			</tr>
			<tr>
				<td>商品原价<font color="red">*</font></td>
				<td><input type="text" name="goprice" /></td>
			</tr>
			<tr>
				<td>商品折扣价<font color="red">*</font></td>
				<td><input type="text" name="grprice" /></td>
			</tr>
			<tr>
				<td>商品数量<font color="red">*</font></td>
				<td><input type="text" name="gstore" /></td>
			</tr>
			<tr>
				<td>商品图片<font color="red">*</font></td>
				<td>
					<input type="file" id="gpicture" name="gpicture"/></td>
			</tr>
			<tr>
				<td>商品类型<font color="red">*</font></td>
				<td><select name="typeid">
						<c:forEach var="gtp" items="${goodsType}">
							<option value="${gtp.id}">${gtp.typename}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /></td>
				<td align="left"><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
