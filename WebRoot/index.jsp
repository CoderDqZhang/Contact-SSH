<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>验证用户名跟手机号-一起学习jquery吧-www.mianfeimoban.com</title>
<link href="css/username.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/username.js"></script>
</head>
<body>
<div class="mb_form">
<h3>登录</h3>
<div class="form_body">
<form name="myform" class="myform" action="" method="post">
	<input type="text" value="" id="username"  />
	<input type="text" value="" id="phone" />
	<input type="submit" id="queren" value="确定" onclick="window.location.href='Manager.jsp'">
	<input type="reset" id="reset" value="重置">
</form></div>
</div>
</body>
</html>
