<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${param.fruit == 1 }">
			1번은 사과
		</c:when>
		
		<c:when test="${param.fruit == 2 }">
			2번은 복숭아
		</c:when>
		
		<c:when test="${param.fruit == 3 }">
			3번은 딸기
		</c:when>
		
		<c:otherwise>
			이건 과일도 아니고 넌 무엇이냐!
		</c:otherwise>
	</c:choose>
<!-- http://localhost:8080/0518_ExpressionLanguage/03_fruitResult.jsp?fruit=1 -->
</body>
</html>