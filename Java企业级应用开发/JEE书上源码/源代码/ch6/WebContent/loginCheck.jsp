<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCheck.jsp</title>
</head>
<body>
<form action="loginCheckServlet" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="name"/></td>
    		</tr>
    		<tr>
    			<td>密   码：</td>
    			<td><input type="password" name="pwd"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交"/></td>
    			<td><input type="reset" value="重置"/></td>
    		</tr>
    	</table>	
    </form>
</body>
</html>