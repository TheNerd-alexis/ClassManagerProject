<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 자바 코드 표현식 </h1> <hr>
== 연산자 사용 결과(서로 다른 객체) : <%= request.getParameter("id") == "pinksung" %> <br>
equals() 사용 결과(서로 같은 문자) : <%= request.getParameter("id").equals("pinksung") %>
<br><br><br>


<h1> EL식 </h1> <hr>
== 연산자 사용 결과( = JAVA *.equals() ) : ${param.id == "pinksung"}<br>
<!--  Param 의 값이 null 인 경우, null로 표시되지 않고, 공백으로만 표기된다. if문을 응용하여 null 검사 가능(equals) -->
<!--  EL식 에서의 == 연산자는 JAVA에서 Equals 와 동일하다. (즉, 같은 문자인지 아니닌지를 비교함) -->
<!--  http://localhost:8080/0517_ExpressionLanguage/05_old.jsp?id=pinksung  -->
</body>
</html>