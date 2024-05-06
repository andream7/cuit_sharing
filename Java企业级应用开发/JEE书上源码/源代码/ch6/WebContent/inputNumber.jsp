<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputNumber.jsp</title>
</head>
<body>
 <FORM action="handleComputer" method=post name=form>
   输入两个数:
   <Input type=text name="numberOne"  size=8>
       <Select name="operator">
          <Option value="+">+(加)
          <Option value="-">-（减）
          <Option value="*">*（乘）
          <Option value="/">/（除）
       </Select> 
   <Input type=text name="numberTwo"  size=8>
   
       <BR>
     <INPUT TYPE="submit" value="提交你的选择" name="submit">
  </FORM> 
</body>
</html>