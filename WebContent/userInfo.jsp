<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.zwhem.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
	<div id="header"><%@ include file="top.jsp"%></div>
	<div id="allcontent" align=center>
		
		<div id="content" ><%@ include file="userself.jsp"%></div>
	</div>	
	<div id="footer">
			<%@ include file="bottom.jsp"%>
		</div>
</body>
</html>