<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1></h1>
<div class="band_main_page2_Img">
	<img src="${cp }/${imgname }">
</div>
<div class="band_main_page2_w">
<h1>${bandname }</h1>
<p>맴버</p>&nbsp;<p>${memberscount }명</p><br>

<p>▷</p><a href="${cp }/mainpagedata.do">밴드 정보 보기</a><br>
<p>${band_intoroductio}</p><br>
<p>○</p><a href="${cp }/setBand_page.do">밴드 설정</a><br>
</div>
</body>
</html>