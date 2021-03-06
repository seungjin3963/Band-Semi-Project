<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>band_main_page</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" type="text/css" href="${cp }/band_main_page/band_main_page_css/band_main_page_css.css">
<!-- include libraries(jQuery, bootstrap) -->
<%-- <script src="<%=cp%>/Resources/js/jquery.min.js"></script> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${cp}/Resources/css/bootstrap.css" rel="stylesheet">
<script src="${cp }/Resources/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link href="${cp }/summernote/summernote.css" rel="stylesheet">
<script src="${cp }/summernote/summernote.js"></script>

<!-- include summernote-ko-KR -->
<script src="${cp }/summernote/lang/summernote-ko-KR.js"></script>
</head>
<body>
<div class="band_main_page">

 <!--  로그인 번호:${sessionScope.login_num}<br>
 
 등급:${sessionScope.band_approved }<br>
 
 밴드 번호${sessionScope.b_n }<br>
 
 밴드 유저 번호:${sessionScope.userband_num }<br>
 
 이미지 :${sessionScope.imgname }<br>

밴드 이름: &{sessionScope.band_name}<br>

소개글 : &{sessionScope.band_intoroductio}<br>

   -->


	
	
	
	<div class="band_main_page_h">	
		<div class="band_main_page_h_1">	
			<!-- 승진이형 header -->
			<jsp:include page="../MakingBand/bandList_header.jsp"/>
		</div>
		<c:if test="${sessionScope.band_approved==1 || sessionScope.band_approved==2}">
			<div class="band_main_page_h_2">
				<jsp:include page="/band_main_page/band_main_page_h/band_main_page_h2.jsp"></jsp:include>
			</div>
		</c:if>		
	</div>
	
	<!-- main -->
	
	<div class="band_main_page_m">		
		<div class="band_main_page_m_1">
			
			<c:choose>
				<c:when test="${sessionScope.band_approved==1 || sessionScope.band_approved==2}">
					<jsp:include page="/band_main_page/band_main_page_m1/band_page_login.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include page="/band_main_page/band_main_page_m1/band_page_logout.jsp"></jsp:include>
				</c:otherwise>		
			</c:choose>
		</div>
		<div class="band_main_page_m_2">
			
			<jsp:include page="${file }"></jsp:include>
			
			<!-- 게시글 사진첩 일정 맴버 -->
		
		</div>
		<div class="band_main_page_m_3">
			<c:if test="${sessionScope.band_approved==1 || sessionScope.band_approved==2}">
				<jsp:include page="/band_main_page/band_main_page_m3/bandpageImg.jsp"></jsp:include>
			</c:if>
		</div>
		
	</div>
<div>
</body>
</html>