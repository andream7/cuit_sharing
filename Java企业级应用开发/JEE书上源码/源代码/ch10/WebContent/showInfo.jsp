<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示下载文件</title>
</head>
<body>
  <table border="1">
		<tr bgcolor="LightGreen">
			<th>文件名称</th>
			<th>下载课件</th>
		</tr>
  <c:forEach var="afile" items="${fileList}">
  	<tr>
  		<!-- afile.name相当于file.getName() -->
  		<td>${afile.name}</td>
  		<td align="center"><a href="downloadServlet?resPath=${afile.name}" style="text-decoration:none">下载</a></td>
  	</tr>
  </c:forEach>
  </table>
</body>
</html>