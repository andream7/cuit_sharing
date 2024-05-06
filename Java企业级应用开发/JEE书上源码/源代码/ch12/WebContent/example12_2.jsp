<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12_2.jsp</title>
<script type="text/javascript">
function createXHR(){
	var xmlhttp;
	if (window.XMLHttpRequest){//支持XMLHttpRequest
	    xmlhttp = new XMLHttpRequest();
	}else{
	    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
function ajaxFunction(sno){
	//创建XMLHttpRequest对象
	xhr = createXHR();
	//设定请求地址
	var url = "AjaxTestServlet?sno=" + sno;
	//建立对服务器的调用
	xhr.open("GET", url, true);
	//指定响应事件处理函数
	xhr.onreadystatechange = function(){
		//当readyState等于4且状态为200时，表示响应已就绪
		if(xhr.readyState ==4 && xhr.status == 200){
			/*//对响应结果进行处理
			var resData = xhr.responseText.split(",");
			//将响应数据更新到页面控件中显示
			document.getElementById("sname").value = resData[0];
			document.getElementById("sage").value = resData[1];
			document.getElementById("sdept").value = resData[2];
			*/
			//将响应的JSON格式转换为JavaScript对象
			var resData = eval("(" + xhr.responseText + ")");
			//将响应数据更新到页面控件中显示
			document.getElementById("sname").value = resData.sname;
			document.getElementById("sage").value = resData.sage;
			document.getElementById("sdept").value = resData.sdept;
		}
	};
	//向服务器发出请求
	xhr.send();
}
</script>
</head>
<body>
	<h1>获取学号对应的学生信息</h1>
	<p>学号：<input type="text" name="sno" onblur="ajaxFunction(this.value)"/></p>
	<p>姓名：<input type="text" id="sname" name="sname" readonly/></p>
	<p>年龄：<input type="text" id="sage" name="sage" readonly/></p>
	<p>院系：<input type="text" id="sdept" name="sdept" readonly/></p>
</body>
</html>