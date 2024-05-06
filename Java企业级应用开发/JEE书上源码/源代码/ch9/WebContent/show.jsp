<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL隐含对象</title>
</head>
<body>
从Servlet转发过来的request内置对象的数据如下：<br>
	${requestScope.name[0]}<br>
	${requestScope.name[1]}<br>
	${requestScope.name[2]}<br>
	<!-- requestScope可以省略 -->
	${name[3]}<br>
	${true}、${200}、${16.7}、${"hello"}、${null}
</body>
</html>