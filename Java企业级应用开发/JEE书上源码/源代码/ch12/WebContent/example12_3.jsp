<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example12_3.jsp</title>
<script type="text/javascript">
function opJSON(){
	//将JSON数据赋值给变量stu
	var stu = {
			"sno":"2019022299999",
			"sname":"陈恒",
			"hobby":["篮球","足球"],
			"college":{
				"cname":"清华大学",
				"city":"北京"
		}
	};
	//获取JSON数据中对象信息
	alert(stu.sno);
	alert(stu.hobby[0]);
	alert(stu.college.cname);
	//定义JSON文本变量
	var jsonText = "{\"sname\":\"陈恒\", \"sage\":\"88\"}";
	//将JSON文本转换为JavaScript对象
	//两边加圆括号将参数值无条件地视为表达式进行解析
	var jsObj = eval("("+ jsonText + ")");
	//获取对象属性
	alert(jsObj.sname);
	
	var obj = { "sname":"陈恒", "sno":20190101, "sage":88};
	var myJSON = JSON.stringify(obj);
	alert(myJSON);
}
</script>
</head>
<body>
<a href="javascript:opJSON()">在JavaScript中处理JSON数据</a>
</body>
</html>