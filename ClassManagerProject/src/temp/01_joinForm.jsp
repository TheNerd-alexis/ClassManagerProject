<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html, body {height:100%;}
html {display:table; width:100%;}
body {display:table-cell; text-align:center; vertical-align:middle;}
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<h1>Register Form</h1>
<form action="joinServlet123" method="POST">
계정: &nbsp; &nbsp;<input type="text" name="id" maxlength="20"><br>
암호: &nbsp; &nbsp;<input type="password" name="pw" maxlength="20"><br>
이름: &nbsp; &nbsp;<input type="text" name="name" maxlength="20"><br>
이메일: <input type="text" name="email" maxlength="20"><br><br>
<input type="submit" value="가입완료"> &nbsp; &nbsp; <input type="reset" value="입력 초기화">
</form>




</body>
</html>