<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 01_movieList</title>
</head>
<body>

	<%
		String[] movieList = { "타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
		pageContext.setAttribute("ml", movieList);
		
	%>
	
	<ul>
	<c:forEach var="mm" items="${ml }" varStatus="status1">
		<c:choose>
			<c:when test="${status1.first }">
				<li style="font-weight: bold; color red;">${mm }</li>
			</c:when>
			
			<c:otherwise>
				<li>${mm }</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
	
	
	<c:forEach var="mm2" items="${ml }" varStatus="status1">
		 { ${mm2 }<c:if test="${! status1.last}"> },<br></c:if>
<!-- 		 not(or !) 반복문이 마지막으로 돌리는 경우가 아니면 ,을 덧붙임 -->
	</c:forEach>
	};
</body>
</html>