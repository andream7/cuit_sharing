<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8"> 
		<title>��Ʒ����</title>
		<link href="beforeUser/css/daohang.css" rel="stylesheet" type="text/css" />
		<link href="beforeUser/css/common.css" rel="stylesheet" type="text/css" />
		<link href="beforeUser/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function submitorder(total){
				if(window.confirm("�Ƿ�����ύ�������ύ�󲻿����޸Ķ�����Ϣ��")){
					window.location.href="before_ordersubmit?amount=" + total;
					return true;
				}
				return false;
			}
 		</script> 
	</head>
  <body>
	<div class="blank"></div>
	<div class="block clearfix"><!--��ǰλ��-->
	<div class="location ared">��ǰλ�ã�<a href="index.php">��ҳ</a> > �������� > ȷ�϶�����Ϣ</div>
	<div class="blank"></div>
			<div class="nFlowBox">
   <form action="" method="post">
    <h6>��Ʒ�б�</h6>
             <table style="width:99%; align-content: center;">
            <tr>
              <th bgcolor="#ffffff">��Ʒ����</th>
              <th bgcolor="#ffffff">�г��۸�</th>
              <th bgcolor="#ffffff">��������</th>
              <th bgcolor="#ffffff">С��</th>
            </tr> 
           <c:forEach var="ce" items="${cartlist}"> 
            <tr>
              <td bgcolor="#ffffff" align="center">
                  	${ce.gname}
              </td>
              <td align="center" bgcolor="#ffffff">${ce.grprice}</td>
              <td align="center" bgcolor="#ffffff">
                ${ce.shoppingnum}
              </td>
              <td align="center" bgcolor="#ffffff">��&nbsp;${ce.smallsum}&nbsp;Ԫ </td>
            </tr>
       	  </c:forEach>
       	  	<tr>
       	  		<td bgcolor="#ffffff" colspan="4" align="right">
       	 			Ӧ���� 
       	 			<font class="pricetype" size="5" color="red">��&nbsp;${total}&nbsp;Ԫ</font>  	
              </td>
          </tr>   	
        </table>   
        <div align="center" style="margin:8px auto;">
       		 <img style="cursor:pointer;"  onclick="submitorder(${total})" src="beforeUser/images/bnt_subOrder.gif" />
    	</div>  
    	<input type="hidden" name="goodsamount" value="20"/>
    </form>
</div>
</div>
</body>
</html>




