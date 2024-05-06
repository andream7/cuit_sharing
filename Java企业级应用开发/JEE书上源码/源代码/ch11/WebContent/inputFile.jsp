<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>从Excel导入到数据库</title>
</head>
<body>
	选择导入的Excel文件：
	<form action="readExcelFileServlet" method="post">
		<input type="file" name="filePath">
		<input type="submit" value="导入">
	</form>
</body>
</html>