<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
    <span style="font-size:12px"><body>  
     <form action="uploadAction" method="post" enctype="multipart/form-data" >   
         请选择需要上传的文件：<input type="file" id="dofile" name="file"/><br />
         员工登录密码:<input type="text" name="password"><br/>
         <input type="submit" id="btnupload" name="btnupload" value="开始上传">  
     </form>  
  </body></span>  
  </body>
</html>
