<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 밴드 소개 페이지  -->
</head>
<body>
<div class="band_page_data">
	<h1>밴드 소개</h1>
	<div class="band_page_data0">
		<h4>밴드 소개글</h4>
		<p>${band_intoroductio}</p>
		<br>
		<br>
		<br>
		<br>
		<h4>이 밴드의 활동 정보</h4>
		
		 <ul>
		 	<li>개설일 &nbsp; yyyy/mm/dd</li>
		 	<li>게시글 &nbsp; n 건</li>
		 	<li>밴드 가입 &nbsp; &{memberscount}명</li>
		 </ul>
		 <br>
		<br>
		<br>
		<br>
	</div>
</div>
<br>
<div id="band_page_data1">
	<div class="band_page_data1">
		<div class="band_page_data1_Img"></div>
		<p>맴버만 게시글을 볼 수 있습니다.</p>
		<p id="band_page_data1_p">밴드에 가입해보세요!</p>
	</div>
</div>
</body>
</html>