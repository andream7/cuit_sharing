<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12_5.jsp</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<span id="myReceive"></span>
<script type="text/javascript">
//加载LoadTestServlet响应数据同时，传递数据sname
$("#myReceive").load("LoadTestServlet",{sname:"陈恒"},function(responseTxt, statusTxt, xhr){
	if(statusTxt=="success"){
		//将JSON文本转换为JavaScript对象
		var stu = eval("("+ responseTxt + ")");
		$("#myReceive").html("学号：" + stu.sno + "<br>姓名：" + stu.sname
				+ "<br>年龄：" + stu.sage + "<br>院系：" + stu.sdept);
	}
	if(statusTxt=="error")
	   alert("Error: "+xhr.status+": "+xhr.statusText);
});
</script>
</body>
</html>