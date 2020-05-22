<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="${cp }/upload.jsp" method="post" enctype="multipart/form-data" style="text-align: center;">
		<label for="selectimg">
			<img src="<%=request.getContextPath()%>/images/1.jpg" style=" width:130px; height:130px; border-radius: 70%; overflow: hiddin;" id="profileimg">
		</label><br> 
		<input type="text" name="nickname" style="margin-top: 10px;"><br> 
		<input type="file" name="potofile" id="selectimg" accept="image/git, image/jpeg, image/png">
		<input type="hidden" value="${sessionScope.login_num }" name="login_num">
		<input type="submit" value="확인" style="margin-top: 10px; width: 100px; height: 40px; background-color: black; color: white;">
	</form>
</div>
</body>
</html>