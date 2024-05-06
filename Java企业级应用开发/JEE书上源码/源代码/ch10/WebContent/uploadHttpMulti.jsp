<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HttpServletRequest对文件上传的支持</title>
</head>
<body>
	<form action="uploadHttpMultiServet" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>文件1描述：</td>
				<td><input type="text" name="filediscription1"></td>
			</tr>
			<tr>
				<td>请选择文件1：</td>
				<td><input type="file" name="resPath1"></td>
			</tr>
			<tr>
				<td>文件2描述：</td>
				<td><input type="text" name="filediscription2"></td>
			</tr>
			<tr>
				<td>请选择文件2：</td>
				<td><input type="file" name="resPath2"></td>
			</tr>
			<tr>
				<td align="right"><input type="reset" value="重填"></td>
				<td><input type="submit" value="上传"></td>
			</tr>
		</table>
	</form>
</body>
</html>