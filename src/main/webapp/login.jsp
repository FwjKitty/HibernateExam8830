<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache"> 
</head>
<body>
	<form action="login.action" method="post">  
        用户：<input type="text" name="user.un"/><br/>  
        密码：<input type="password" name="user.pw"/><br/>  
        <input type="submit" value="登录">
    </form> 
</body>
</html>