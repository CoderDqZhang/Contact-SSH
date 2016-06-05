<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ChangeUser.jsp' starting page</title>
    
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
    <form action="changeContactAction">
          用户名:<input type="text" name="username"><br/>
          电话:<input type="text" name="phone"><br/>
          家乡:<input type="text" name="home"><br/>
          部门:<input type="text" name="department"><br/>
          职位:<input type="text" name="position"><br/>
          邮箱:<input type="text" name="email"><br/>
          qq:<input type="text" name="qq"><br/>
          年龄:<input type="text" name="age"><br/>
          公司:<input type="text" name="company"><br/>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>
  </body>
</html>
