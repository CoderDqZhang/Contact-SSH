<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <input type="submit" id="queren" value="上传电话本" onclick="window.location.href='upload.jsp'">
    <input type="submit" id="queren" value="修改个人信息" onclick="window.location.href='ChangeUser.jsp'">
    <input type="submit" id="queren" value="获取所有联系人" onclick="window.location.href='GetCompay.jsp'">
    <input type="submit" id="queren" value="管理界面" onclick="window.location.href='Manager.jsp'">
    <input type="submit" id="queren" value="获取分组联系人" onclick="window.location.href='departmentGroup.jsp'">
  </body>
</html>
