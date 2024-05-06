<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>添加类型</title>
<link href="admin/css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
	<form action="admin_Type?act=add" method="post">
		<table border=1 style="border-collapse: collapse">
			<caption>
				<font size=4 face=华文新魏>添加类型</font>
			</caption>
			<tr>
				<td>类型名称<font color="red">*</font></td>
				<td><input type="text" name="typename" /> 
				</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /></td>
				<td align="left"><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>