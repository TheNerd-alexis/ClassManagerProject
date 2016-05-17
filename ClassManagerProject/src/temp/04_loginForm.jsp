<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 04_loginForm EL과 JSTL</title>
</head>
<body>

<form method="get" action="04_testLogin.jsp">
	<label for="labeluser"> 아이디 : </label>
	<input type="text" name="id" id="labeluser"> <br>
	
	<label for="labelpwd"> 암 &nbsp; 호 : </label>
	<input tyhpe="password" name="pwd" id="labelpwd"> <br>
	
	<input type="submit" value="로그인">
</form>

</body>
</html>