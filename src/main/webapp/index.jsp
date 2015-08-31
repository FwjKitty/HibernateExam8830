<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>index</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache"> 
</head>
<body>
	<s:text name="label.hello">
		<s:param>${un}</s:param>
	</s:text>
	<s:property value="%{getText('label.hello')}"/>
</body>
</html>