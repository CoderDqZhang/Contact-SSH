<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
</head>
<body>
    <form action="userLogin">
          用户名:<input type="text" name="username"><br/>
          密码:<input type="password" name="password"><br/>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>
</body>
</html>