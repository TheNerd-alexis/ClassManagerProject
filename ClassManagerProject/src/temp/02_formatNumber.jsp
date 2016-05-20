<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:formatNumber value="1234567.89"/> <br> <%-- groupingUsed="true" --%>
<fmt:formatNumber value="1234567.89" groupingUsed="false" /> <br>
<fmt:formatNumber value="0.5" type="percent" /> <br> <%-- value * 100 = percent --%>
<fmt:formatNumber value="10000" type="currency" /> <br>
<fmt:formatNumber value="10000" type="currency" groupingUsed="false" currencySymbol="$"/> <br> <%-- out: $10,000 --%>

<fmt:formatNumber value="1234567.8912345" pattern="#,#00.0#" /> <br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#" /> <br>
<fmt:formatNumber value="1234567.89" pattern=".000" /> <br>

</body>
</html>