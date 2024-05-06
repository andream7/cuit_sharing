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
<title>addnotice.jsp</title>
<link href="admin/css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
	<form action="admin_noticeManager?act=add" method="post">
		<table border=1 style="border-collapse: collapse">
			<caption>
				<font size=4 face=华文新魏>添加公告</font>
			</caption>
			<tr>
				<td>公告标题<font color="red">*</font></td>
				<td><input type="text" name="ntitle" /> 
				</td>
			</tr>
			<tr>
				<td>公告内容<font color="red">*</font></td>
				<td><textarea rows="10" cols="30" name="ncontent"></textarea> </td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /></td>
				<td align="left"><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>