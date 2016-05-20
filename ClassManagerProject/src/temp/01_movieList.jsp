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

<table border="1" style="width:100%"; text-align: center;>
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
	
	<c:forEach var="m" items="${ml}" varStatus="status1">
		<tr>
			<td>${status1.index}</td>
			<td>${status1.count}</td>
			<td align="center">
			
				<c:if test="${m == '타이타닉'}">
					<span style="color: green;">타이타닉</span><br>
				</c:if>
			${m}
			
			</td>
		</tr>
		
	</c:forEach>
	
</table>




</body>
</html>