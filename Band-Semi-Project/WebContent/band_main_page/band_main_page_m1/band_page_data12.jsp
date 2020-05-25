<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.band_page_data{width: 96.5%; height: auto; background-color: white; border: 1px solid white;padding-left: 20px;}
	.band_page_data0{width: 90%; height: auto; margin: auto;}
</style>
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
		<br>
		<h4>이 밴드의 활동 정보</h4>
		 <ul>
		 	<li>개설일 &nbsp; ${band_Date}</li>
		 	<li>게시글 &nbsp; ${countboaed} 건</li>
		 	<li>밴드 가입 &nbsp; ${memberscount} 명</li>
		 </ul>
		 <br>
		<br>
		<br>
		<br>
	</div>
</div>
</body>
</html>