<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12_4.jsp</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function testjQueryAjax(){
	$.ajax({
		//发送请求的地址
		url:"TestjQueryAjaxServlet",
		//请求方式，默认为get
		type:"post",
		//预期服务器返回的数据类型。如果不指定自动根据MIME类型返回信息
		dataType:"text",
		//发送到服务器的数据
		/*data:{
			sno:$("#sno").val(),
			sname:$("#sname").val(),
			sage:$("#sage").val(),
			sdept:$("#sdept").val()
		},*/
		//还可以提交整个form表单，注意表单参数的id和name相同
		data: $("#myForm").serializeArray(),
		//请求成功后回调函数，参数为服务器返回的数据
		success:function(data){
			//将JSON文本转换为JavaScript对象
			var stu = eval("("+ data + ")");	
			$("#myInput").html("学号：" + stu.sno + "<br>姓名：" + stu.sname
					+ "<br>年龄：" + stu.sage + "<br>院系：" + stu.sdept);
		},
		//请求失败时调用的函数
		error:function(){
			alert("处理异常");
		}
	});
}
</script>
</head>
<body>
	<form id="myForm">
		<p>学号：<input type="text"  id="sno" name="sno"/></p>
		<p>姓名：<input type="text" id="sname" name="sname"/></p>
		<p>年龄：<input type="text" id="sage" name="sage"/></p>
		<p>院系：<input type="text" id="sdept" name="sdept"/></p>
		<p><input type="button" value="测试Ajax" onclick="testjQueryAjax()"/></p>
		<p><span id="myInput"></span></p>
	</form>
</body>
</html>