<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
    <h3>登录页面</h3>
    <form action="test/yourLogin.action" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="userName"/></td>
    		</tr>
    		<tr>
    			<td>密  码：</td>
    			<td><input type="password" name="userpwd"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交"/></td>
    			<td><input type="reset" value="重置"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</body>
</html>