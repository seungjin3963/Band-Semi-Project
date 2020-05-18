<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- UserinfoController에서 code 받아옴 (회원가입 성공 했는지) -->
<c:choose>
	<c:when test="${code == 'sucess' }">
		<h1>회원가입 성공</h1>
	</c:when>
	<c:otherwise>
		<h1>회원가입 실패</h1>
	</c:otherwise>
</c:choose>
<a href="${cp }/login/login.jsp">메인으로 돌아가기</a>
</body>
</html>