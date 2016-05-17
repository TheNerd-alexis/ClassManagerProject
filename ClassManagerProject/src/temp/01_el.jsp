<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL과 JSTL</title>
</head>
<body>

<!-- 표현 언어(El, Expression Language : 이렇게 값을 가져오면 편하다 -->
${"Hello"}<br> <!-- Expression Language -->
<%="Hello"%> <br> <!-- 표현식 (Expression) -->
<% out.println("Hello"); %> <br> <!--  스크립트릿 -->

</body>
</html>