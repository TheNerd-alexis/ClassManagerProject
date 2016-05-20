<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// 	request.setAttribute("now", new Date());
%>
	<pre>
		<c:set var="now" value="<%= new Date() %>" />
		\${now } : ${now }
		           <fmt:formatDate value="${now }"></fmt:formatDate>
		date     : <fmt:formatDate value="${now }" type="date" />
		time     : <fmt:formatDate value="${now }" type="time"/>
		both     : <fmt:formatDate value="${now }" type="both"/>
		
		default  : <fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"></fmt:formatDate>
		short    : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"></fmt:formatDate>
		medium   : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"></fmt:formatDate>
		long     : <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"></fmt:formatDate>
		full     : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"></fmt:formatDate>
		
		yyyy년 MM월 dd일 hh시 mm분 ss초" : <fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
	</pre>

</body>
</html>