<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단 2단 Test</title>
</head>
<body>


<%
	// Doget 함수 안에 아래 코드들이 포함되는 것이다.
	// 1번 클라이언트가 호출할 때마다 기본값은 2로 설정된다.
	int dan = 2;

	
	for(int i = 1; i<=9; i++) {
		int result = dan * i;
%>
	
	<%--
	코드가 상당히 더럽다 ... 
	그래도 자주 읽히자 ..
	활용에 쓰이는 것은 아니니 대충 보자.
	--%>
	<%= dan %> * <%= i %> = <%= result %> <br>
	
	
<%
	}
%>


</body>
</html>