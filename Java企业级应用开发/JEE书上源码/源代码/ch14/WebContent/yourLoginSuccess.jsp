<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		从session中取值<br>
      	用户名：${sessionScope.usersession.userName }<br>
      	密码：${sessionScope.usersession.userpwd }<br>
      	从appication中取值<br>
      	用户名：${applicationScope.userapplication.userName }<br>
      	密码：${applicationScope.userapplication.userpwd }
</body>
</html>