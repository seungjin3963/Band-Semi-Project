<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascr67ipt">
	window.onload=function(){
		<%
		//밴드 삭제 탈퇴후 세션 삭제 
		//long login_num=(long)session.getAttribute("login_num");
		//System.out.println("aaaaaaaaaaaaaaaa     " +login_num);
		//session.invalidate();
		//session.setAttribute("login_num", login_num);
		//String cp=request.getContextPath();
		//session.setAttribute("cp", cp);
		%>
		location.href="<%=request.getContextPath()%>/layout.do";
	}
</script>
</head>
<body>
<h1>삭제완료</h1>

</body>
</html>