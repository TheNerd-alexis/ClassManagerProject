<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${param}<br>
${param["season"]}<br> <%--  ${param.season} --%>
${paramValues}<br>
${paramValues.season[1]}
<%
// 	String seasonArr[] = request.getParameterValues("season");
// 	out.println("당신이 좋아하는 계절 : ");
	
// 	for (String season : seasonArr) {
// 		out.println(season + " ");
// 	}

%>

</body>
</html>