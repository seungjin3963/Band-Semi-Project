<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.band_page_open{width: 100%; height: auto; border: 1px solid black; background-color: white;}
	.band_page_open h3{padding-left: 20px;}
	.band_page_open1{width: 90%; height: auto; border: 1px solid black; padding-left: 20px; margin: auto;}
	.band_page_open #input{padding-left: 20px;}
	.band_page_open1rad{float: right; margin-right: 50px;margin-top: 20px;}
</style>
</head>
<body>
<div class="band_page_open">
 	<h3>밴드 공개</h3>
 	<br>
 	<br>
 	<div class="band_page_open1">
 	<h4>비공개 밴드</h4>
 	<input type="radio" value="1" class="band_page_open1rad">
 	<p>밴드와 게시글이 공개되지 않습니다. 초대를 통해서만 가입할 수 있습니다.</p>
 	</div>
 	<br>
 	<div class="band_page_open1" >
 	<h4>밴드명 공개 밴드</h4>
 	<input type="radio" value="2" class="band_page_open1rad">
 	<p>누구나 밴드를 검색으로 찾아 밴드 소개를 볼 수 있지만, 게시글은 멤버만 볼 수 있습니다.</p>
 	</div>
 	<br>
 	<div class="band_page_open1">
 	<h4>공개 밴드</h4>
 	<input type="radio" value="3" class="band_page_open1rad">
 	<p>누구나 밴드를 검색해 찾을 수 있고, 밴드 소개와 게시글을 볼 수 있습니다.</p>
 	</div>
 	<br>
 	<br>
 	<br>
 	<input type="button" value="저장하기" id="input">
 	<br>
 	<br>
 	<br>
 	<br>
</div>
</body>
</html>