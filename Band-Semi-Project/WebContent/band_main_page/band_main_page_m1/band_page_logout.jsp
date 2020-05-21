<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.band_page_logout_madal{width: 100%; height:100px; }
	.band_page_logout_Img{width:60px;height:60px; border: 1px solid black; border-radius: 70px; float: left;}
	
	.band_page_logout_madal h4{float: left; margin-left: 15px; margin-top: 20px;}
	.band_page_logout_madal input {float: right; }
	.band_main_page1_Img img{width: 100%; height: 180px;}
</style>
</head>

<body>
<div class="band_main_page1_Img">
	<img src="${cp }/${imgname }">
</div>
<div class="band_main_page1_w">
<h1>${bandname }</h1>
<p>맴버</p>&nbsp;<p>${memberscount }명</p>>&nbsp;<p>리더</p>&nbsp;<p>김영노</p>
&nbsp;&nbsp;<button type="button" data-toggle="modal" data-target="#myModal">밴드 가입하기</button><br>
<br>
<p>▷</p><a href="${cp }/mainpagedata.do">밴드 정보 보기</a>
<p>${band_intoroductio}</p><br>
</div>

  <div class="modal fade" id="myModal" role="dialog"> <!-- 사용자 지정 부분① : id명 -->

    <div class="modal-dialog" style="width:400px;">

      <!-- Modal content-->

      <div class="modal-content">

        <div class="modal-header">

          <button type="button" class="close" data-dismiss="modal">×</button>

          <h4 class="modal-title" >밴드 이름</h4> <!-- 사용자 지정 부분② : 타이틀 -->
		<p >이 밴드에 사용할 프로필을 선택해 주세요.</p>
        </div>

        <div class="modal-body" >
			<div class="band_page_logout_madal">
				<div class="band_page_logout_Img" > <!-- 프로필 이미지 -->  </div>
				<h4 id="rkdlqname">김영노</h4>
				<input type="radio" > <!-- 사용자 지정 부분③ : 텍스트 메시지 -->
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
        </div>

        <div class="modal-footer">

          <input type="button" class="btn btn-default" data-dismiss="modal"  value="가입하기" draggable="true" onclick="band_rkdlqgkrl()">

        </div>

      </div>

    </div>

  </div>
<br/><br/>
<script type="text/javascript">
	
	
	var xhr=null;
	function band_rkdlqgkrl() {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=band_rkdlqgkrl_value;
		xhr.open('get','<%=request.getContextPath()%>/membersrkdlq.do',true);
		xhr.send();
	}
	function band_rkdlqgkrl_value() {
		if(xhr.readyState==4 && xhr.status==200){
			alert("밴드 가입 요청이 완료되었습니다");	
		}
	}
</script>
</body>
</html>


