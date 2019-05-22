<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看</title>
</head>
<body>

	<form action="selectUser.do">
	id<input type="text" id="id" name="name" value="${user.id }">
	<br>
	姓名<input type="text" id="name" name="name" value="${user.name }">
	<br>
	年龄<input type="text" id="age" name="age" value="${user.age }">
	<br>
	密码<input type="text" id="password" name="password" value="${user.password }">
	<br>
	<input type="submit" value="返回">
	</form>
</body>
</html>