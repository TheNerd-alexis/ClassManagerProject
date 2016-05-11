<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
// <Main.jsp>
// ~ 님 환영합니다.
// [로그아웃 버튼]
		

		
// main.jsp -> ~님 환영합니다. (로그인 성공할 경우)
// main.jsp -> loginForm.jsp로 리다이렉트 (로그인 실패할 경우)

// loginForm.jsp 에는 id와 pw를 입력하고 버튼을 누르면 LoginServlet.java(서블릿)으로 이동

// login.java(서브릿) 에서는 id와 pw가 서로 같을 경우 로그인 성공,
// 로그인 성공이면 쿠키에 id를 지정하고 main.jsp로 리다이렉트,
// 로그인 실패면 그냥 main.jsp로 리다이렉트

// 로그아웃 버튼을 누르면 LogoutServlet.java(서블릿) 으로 이동
// LogoutServlet.java(서블릿) 에서는 id 쿠키 값을 삭제하고 Main.jsp로 리다이렉트

%>


<%
// 	Cookie[] cookies2 = request.getCookies();
// 	int arrIndex = 0;
// 	for (Cookie c : cookies2) {
// 		out.println(arrIndex + "쿠키 리스트: " + c.getName()+ ": " + c.getValue()+ "<br>");
// 		arrIndex ++;
// 	}

%>


<%
	Cookie[] cookies = request.getCookies();
	boolean isLogin = false;
	String id = null;
	
	for(Cookie c : cookies) {
		
		if (c.getName().equals("id"))
		{
			isLogin = true;
			id = c.getValue();
		}
	}
	
	if(isLogin) {
		out.println(id + "님 환영합니다.");
		%>
			<input type="button" value="로그아웃" onclick="location.href='LogoutServlet456'">
		<%
	}
	
	else {
		response.sendRedirect("04_exLoginForm.jsp");
	}

	
// 	if(cookies.length > 1) { ...
// 		cookies[1].getValue() 님 환영합니다.
// 	}
%>

<!-- <form action="LogoutServlet456" method="GET"> -->
<!-- 	<input type="submit" value="로그아웃"> -->
<!-- </form> -->

</body>
</html>