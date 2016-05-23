<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 목록 조회 결과</title>
</head>

<%
//<td>${member.admin == 0 ? "관리자" : "일반회원" }</td>
%>
<body>

	<table>
		<tr align="left">
			<th>번호</th>
			<th>이름</th>
			<th>계정</th>
			<th>암호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>권한</th>
		</tr>
		
		<c:forEach var="member" varStatus="status1" items="${memberList }">
			<tr>
				<td>${status1.count }</td>
				<td>${member.name }</td>
				<td>${member.userid }</td>
				<td>${member.pwd }</td>
				<td>${member.email }</td>
				<td>${member.phone }</td>
				<td>
					<c:choose>
						<c:when test="${member.admin == 1 }">
							관리자
						</c:when>
						<c:otherwise>
							유저
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value="뒤로가기" onclick="location.href='javascript:history.go(-1)'">


</body>
</html>