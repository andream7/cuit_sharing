<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12_1.jsp</title>
<script type="text/javascript">
	function createXHR(){
		var xmlhttp;
		if (window.XMLHttpRequest){//支持XMLHttpRequest
		    //IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp = new XMLHttpRequest();
		    alert("新浏览器");
		}else{
		    //IE6, IE5 浏览器执行代码
		    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		    alert("老旧浏览器");
		}
	}
</script>
</head>
<body>
	<a href="javascript:createXHR()">创建XMLHttpRequest对象</a>
</body>
</html>