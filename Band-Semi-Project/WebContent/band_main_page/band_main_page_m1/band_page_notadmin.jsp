<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.modal-body div h4{color:  green;}
	.band_page_admin #div1 button{float: right;}
</style>
</head>
<body>
<div class="band_page_admin">
	<h1>밴드 설정</h1>
	<br>
	<h4>사용중인 프로필</h4>
	<br>
	<div id="div">
		<div class="band_page_admin_Img"> <!-- 프로필 이미지 -->  </div>&nbsp;&nbsp;&nbsp;
		<h3>김영노</h3>
		<input type="button" value="변경" id="input">
	</div>
	<br>
	<div id="div1">
	<br>
		<h4>밴드 정보 관리</h4>
		<br>
		<div>
		<br>
			밴드 탈퇴
			<button type="button" data-toggle="modal" data-target="#myModal">탈퇴하기</button><br>
		</div>
		<br>
		<br>
		<br>
		<br>
	</div>
</div>


 <div class="modal fade" id="myModal" role="dialog"> <!-- 사용자 지정 부분① : id명 -->

    <div class="modal-dialog" style="width:400px;">

      <!-- Modal content-->

      <div class="modal-content">

        <div class="modal-header">

          <button type="button" class="close" data-dismiss="modal">×</button>

          <h4 class="modal-title" >밴드 탈퇴</h4> <!-- 사용자 지정 부분② : 타이틀 -->
		
        </div>

        <div class="modal-body" >
        	<div>
			<h4>밴드 탈퇴 전에 꼭 확인하세요</h4>
			<p>밴드를 탈퇴하면,<br>
			이 밴드에 내가 등록한 글, 사진, 댓글 등을 수정/삭제할 수 없습니다. 필요하면 탈퇴 전에 수정하거나 삭제해주세요.</p><br>
			<p>이 밴드 멤버들과의 모든 채팅방에서 나가게 됩니다. 보관하고 싶은 대화가 있다면 탈퇴 전에 채팅방 설정에서 [대화내용 내보내기]를 이용하세요.</p>
			</div>
        </div>

        <div class="modal-footer">

          <input type="button" class="btn btn-default" data-dismiss="modal"  value="취소">
           <input type="button" class="btn btn-default" data-dismiss="modal"  value="탈퇴하기">

        </div>

      </div>

    </div>

  </div>
</body>
</html>