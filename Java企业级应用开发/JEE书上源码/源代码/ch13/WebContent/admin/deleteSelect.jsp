<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
<title>deleteSelect.jsp</title>
<link href="admin/css/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse
		}
		.bgcolor{
    		background-color: #F08080;
    	}
	</style>
	<script type="text/javascript">
  		function confirmDelete(){
  			var n=document.deleteForm.gno.length;
  			var count=0;//统计没有选中的个数
  			for(var i=0;i<n;i++){
  				if(!document.deleteForm.gno[i].checked){
  					count++;
  				}else{
  					break;
  				}
  			}
  			if(n>1){//多个商品
  				//所有的商品都没有选择
  				if(count==n){
  					alert("请选择删除的商品！");
  	  				count=0;
  	  				return false;
  					
  				}
  			}else{//一个商品
  				//就一个朋友并且还没有选择
  	  			if(!document.deleteForm.gno.checked){
  	  					alert("请选择删除的商品！");
  	  					return false;
  	  			}
  			}	
  			if(window.confirm("真的删除吗？really?")){
  				document.deleteForm.submit();
  				return true;
  			}
  			return false;
  		}
  		function checkDel(id){
  			if(window.confirm("是否删除该商品？")){
  				window.location.href="admin_deleteGoods?act=link&gno="+id;
  			}
  		}
  		function changeColor(obj){
  			obj.className="bgcolor"
  		}
  		function changeColor1(obj){
  			obj.className=""
  		}
  </script>
</head>
<body>
	<br>
	<form action="admin_deleteGoods" name="deleteForm">
	<table border="1">
		<tr>
			<th width="250px">商品ID</th>
			<th width="200px">商品名称</th>
			<th width="200px">商品类型</th>
			<th width="200px">查看详情</th>
			<th width="200px">操作类型</th>
		</tr>
		<c:forEach var="g" items="${requestScope.allGoods}">
			<tr  onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
				<td>
					<input type="checkbox" name="gno" value="${g.id}"> 
					${g.id}
				</td>
				<td>${g.gname}</td>
				<td>${g.typename}</td>
				<td><a href="admin_detail?gno=${g.id}&act=detail" target="_blank">详情</a></td>
				<td>
					<a href="javascript:checkDel('${g.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
		  <tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="admin_selectGoods?act=${act }">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
					</c:url>
					<c:url var="url_next" value="admin_selectGoods?act=${act }">
						<c:param name="pageCur" value="${pageCur + 1 }"/>
					</c:url>
					<!-- 第一页没有上一页 -->
					<c:if test="${pageCur != 1 }">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<!-- 最后一页，没有下一页 -->
					<c:if test="${pageCur != totalPage && totalPage !=0 }">
						<a href="${url_next}">下一页</a>
					</c:if>
				</td>
			</tr>  
		<tr>
			<td colspan="5">
				<input type="hidden" name="act" value="button"> 
				<input type="button" value="删除" onclick="confirmDelete()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>