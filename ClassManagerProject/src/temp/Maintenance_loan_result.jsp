<%@page import="model.Loan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>대출 이자 계산 결과</title>
</head>
<body>
	<table>
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>대출잔액</th>
		</tr>
		
		<c:forEach var="loan" items="${list }" varStatus="status1">
			<tr>
				<td>${loan.index }</td>
				<td>${loan.totalRepay }</td>
				<td>${loan.originRepay }</td>
				<td>${loan.interestRePay }</td>
				<td>${loan.remainAmount }</td>
			</tr>
		</c:forEach>
		<!--  게터 세터가 있어야만 loan. 으로 접근이 가능합니다! 적을 땐 멤버변수를 적어야 함! -->
	</table>
</body>
</html>