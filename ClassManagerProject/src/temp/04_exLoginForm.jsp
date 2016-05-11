<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>로그인을 하세요!</h2>

<form action="LoginServlet123" method="POST">
	ID: <input type="text" name="id"> <br>
	PW: <input type="password" name="pw"> <br><br>
	<input type="submit" value="로그인">
	<input type="reset" value="다시쓰기">
</form>

</body>
</html>