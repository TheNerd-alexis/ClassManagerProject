<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="member" class="model.MemberBean" scope="session" />
<hr>
@ 자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
이름 : <jsp:getProperty  property="name" name="member"/> <br>
아이디 : <jsp:getProperty property="id" name="member"/>
<hr>

@자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
<jsp:setProperty property="name" name="member" value="전수빈" />
<jsp:setProperty property="id" name="member" value="pinksubin"/>

이름 : <jsp:getProperty property="name" name="member"/> <br>
아이디 : <jsp:getProperty property="id" name="member"/>


</body>
</html>