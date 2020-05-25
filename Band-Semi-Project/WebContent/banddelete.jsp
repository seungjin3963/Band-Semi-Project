<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		<%
		session.removeAttribute("band_approved");
		%>
		location.href="<%=request.getContextPath()%>/layout.do";
	}
</script>
</head>
<body>

</body>
</html>