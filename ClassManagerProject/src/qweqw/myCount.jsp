<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	//JSP로 요청이 들어오면
	//JSP는 서블릿으로 번역되고 (JAVA 코드)
	//번역된 서블릿 자바코드가 컴파일 되고 (*.class)
	//컴파일된 프로그램이 실행되고
	//요청이 들어올 때마다 저 실행된 프로그램에 있는 서블릿 객체가
	//가지고 있는 요청처리 멕소드가 한번씩 호출됨
	
	// 아래 변수는 메소드 안에 있는 지역변수를 의미한다
	int count = 0;
	out.print("count: ");
//	out.println(++count); 스크립틀릿 안에 있는 것은 자바코드이므로 자바 주석과도 같다.
%>

</body>
</html>