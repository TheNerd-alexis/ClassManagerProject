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

<%
// 로그인 loginForm.jsp
// 회원가입 joinForm.jsp
// 로그인 성공 loginResult.jsp (이동 버튼 누를 시 밑으로 이동)
// [main.jsp]로그인 여부 판단해서 loginForm.jsp 로 리다이렉션 .. 수정 화면과 회원 모두 보기 화면으로 이동할 수 있는 버튼 main.jsp

// id ~~~
// pw ~~~
// email ~~
// 확인 취소 - 둘다 main.jsp로 이동


// <id> <name> <email>
// ~    ~      ~
// ~    ~      ~
//     뒤로 - main 으로 이동
%>

<h1>HomePage Main</h1><br>

<form action="loginServlet123">
	계정: <input type="text" name="id" maxlength="20"><br>
	암호: <input type="password" name="pw" maxlength="20"><br><br>
	<input type="submit" value="로그인"> &nbsp; &nbsp; <input type="button" value="회원가입" onclick="location.href='01_joinForm.jsp'">
</form>

</body>
</html>