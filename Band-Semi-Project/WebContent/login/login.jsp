<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="${cp }/Resources/css/bootstrap.min.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${cp }/Resources/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f6f6f6">

<div class="container-fluid">
  <div class="row no-gutter">
    <div style="position: relative; margin-top: 50px; text-align: right;" class="d-none d-md-flex col-md-4 col-lg-6 bg-image">
    	<img id="img1" src="../images/bandLoginImg.PNG">
    </div>
    <div style="position: relative; margin-top: 200px;" class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto" id="login">
              <h3 class="login-heading mb-4">Welcome back!</h3>
              
              <form class="form-inline" method="post">
                <div class="form-label-group">
                  <label for="inputId" class="col-lg-2 control-label">Id</label>
                  <input type="text" id="inputId1" name="loginId" class="form-control" placeholder="Id" required autofocus>
                </div>
                <div class="form-label-group">
                  	<label for="inputPassword" class="col-lg-2 control-label">Password</label>
                 	<input type="password" id="inputPassword" name="loginPwd" class="form-control" placeholder="Password" required>
                </div>

                <div class="custom-control custom-checkbox mb-3">
                </div>
                <div style="display: inline-block">
	                <button class="btn btn-success" type="button" onclick="return check_login()">로그인</button>
	                <input type="button" value="회원가입" class="btn btn-success" data-toggle="modal" data-target="#myModal">
	            </div>
	          </form>
	          
	          
	          
	            <form class="form-inline" method="post">
	                <!-- 모달영역 -->
	                <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
	                	<div class="modal-dialog" role="document">
	                		<div class="modal-content">
	                		
	                			<div class="modal-header">
	                				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                					<span aria-hidden="true">x</span>
	                				</button>
	                				<h4 class="modal-title" id="myModalLabel">회원가입</h4>
	                			</div>
	                			<!-- 회원가입 내용 입력(모달) -->
		                			<div class="modal-body">
		                					<div class="row">
		                						<label for="inputId" class="col-xs-6 col-sm-4">아이디</label>
		                						<input type="text" name="login_id" id="inputId2" class="form-control" placeholder="아이디" required autofocus>
		                						<button type="button" class="btn btn-success btn-xs" onclick="check_id();">중복확인</button>
		                					</div>
		                					<div class="row">
		                						<label for="inputpwd" class="col-xs-6 col-sm-4">비밀번호</label>
		                						<input type="password" id="inputPwd" name="login_pwd" class="form-control" placeholder="비밀번호" required autofocus>
		                					</div>
		                					<div class="row">
		                						<label for="inputpwd" class="col-xs-6 col-sm-4">비밀번호 확인</label>
		                						<input type="password" id="inputPwdOk" class="form-control" placeholder="비밀번호 확인" required autofocus>
		                					</div>
		                					<div class="row">
		                						<label for="inputname" class="col-xs-6 col-sm-4">이름</label>
		                						<input type="text" id="inputName" name="user_name" class="form-control" placeholder="이름" required autofocus>
		                					</div>
		                					
		                					<!-- 생년월일(모달)  -->
		                					<div class="row">
		                						<label for="birth" class="col-xs-6 col-sm-4">생년월일</label>
		                						<select name="year">
		                							<option value="0">연도</option>
		                							<c:forEach var="i" begin="1920" end="2015">
		                								<option value="${i }">${i }</option>
		                							</c:forEach>
		                						</select>
		                						<select name="month">
		                							<option value="0">월</option>
		                							<c:forEach var="i" begin="1" end="12">
		                								<option value="${i }">${i }</option>
		                							</c:forEach>
		                						</select>
		                						<select name="date">
		                							<option value="0">일</option>
		                							<c:forEach var="i" begin="1" end="31">
		                								<option value="${i }">${i }</option>
		                							</c:forEach>
		                						</select>
		                					</div>
		                					<!-- 전화번호(모달) -->
		                					<div class="row">
		                						<label for="user_phone" class="col-xs-6 col-sm-4">전화번호</label>
		                						<input type="text" name="user_phone" id="user_phone" class="form-control" placeholder="전화번호" required autofocus>
		                						<button type="button" class="btn btn-success btn-xs" onclick="check_phone();">중복확인</button>
		                					</div>					
		                					<!-- 성별(모달) -->
		                					<div class="row">
		                						<label for="user_gender" class="col-xs-6 col-sm-4">성별</label>
		                						<input type="radio" name="user_gender" value="w">여성
		                						<input type="radio" name="user_gender" value="m">남성
		                					</div>
		                					
		                					<!-- 퀴즈(모달) -->
		                					<div class="row">
		                						<label for="user_quiz" class="col-xs-6 col-sm-4">퀴즈</label>
		                						<select name="user_quiz" id="user_quiz" class="form-control" style="display:inline-block">
		                							<option value="나의 보물 1호는?">나의 보물 1호는?</option>
													<option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
													<option value="가장 기억에 남는 장소는?">가장 기억에 남는 장소는?</option>
													<option value="어렸을때 살던 지역이름은?">어렸을때 살던 지역이름은?</option>
		                						</select>
		                						<input type="text" name="user_quiz1" id="user_quiz1" class="form-control" value="" style="display:none" placeholder="퀴즈">
		                						<input type="radio" name="quiz_direct" value="direct" onclick="quiz_directa('1')">직접입력
		                					</div>
		                					<!-- 퀴즈 답(모달) -->
		                					<div class="row">
		                						<label for="inputanswer" class="col-xs-6 col-sm-4">답</label>
		                						<input type="text" id="inputAnswer" name="user_answer" class="form-control" placeholder="퀴즈 답" required autofocus>
		                					</div>
		                			</div>
		                			<div class="modal-fotter">
		                				<button type="button" id="join_user" class="btn btn-success" disabled="disabled" onclick="return check_form()">확인</button>
		                				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		                			</div>
	                		</div>
	                	</div>
	                </div>
	                
	                <br>
                <div class="text-left">
                	<a class="text-success" href="${cp }/login/findUser.jsp">아이디 / 비밀번호 찾기</a><br>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">

	$(document).ready(function(){
		$("#inputPassword").keydown(function(e){
			if(e.keyCode==13){
				check_login();
			}
		});
	});
	var xhr = null;
	// 회원가입 확인
	function check_login(){
		var inputId1 = document.getElementById("inputId1");
		var inputPassword = document.getElementById("inputPassword");
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getLogin;
		xhr.open('post','${cp}/loginOk.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('loginId='+inputId1.value+'&loginPwd='+inputPassword.value);
	}
	function getLogin(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var code = xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			console.log(code);
			if(code == "fail"){
				alert("가입되지 않은 회원입니다.");
				return false;
			}else{
				var inputId1 = document.getElementById("inputId1");
				var inputPassword = document.getElementById("inputPassword");
				location.href='${cp}/SendLogin.do?loginId='+inputId1.value+'&loginPwd='+inputPassword.value;
			}
			return true;
		}
	}
	
	var year = document.getElementsByName("year");
	var month = document.getElementsByName("month");
	var date = document.getElementsByName("date");
	var gender = document.getElementsByName("user_gender");
	
	// 생년월일, 성별이 선택 안되었을 때 alert를 띄워줌
	function check_form(){
		var inputPwd = document.getElementById("inputPwd");
		var inputPwdOk = document.getElementById("inputPwdOk");
		
		if(inputPwd.value != inputPwdOk.value){
			alert("비밀번호확인이 다릅니다.");
			return false;
		}else if(inputPwd.value.length < 4){
			alert("비밀번호는 4자리 이상 해주세요");
			return false;
		}
		if(year[0].value == 0 || month[0].value == 0 || date[0].value == 0){
			alert("생년월일을 입력해주세요");
			return false;
		}
		if(gender[0].checked == false && gender[1].checked == false){
			alert("성별을 입력해주세요");
			return false;
		}
		if(inputPwd.value != inputPwdOk.value){
			alert("비밀번호와 비밀번호 확인이 다릅니다.");
			return false;
		}
		
		var pattern_num = /[0-9]/;
		var user_phone = document.getElementById("user_phone");
		if(user_phone.value == 0 || user_phone == null || user_phone == ""){
			alert("전화번호를 입력해주세요");
			return false;
		}else if(!pattern_num.test(user_phone.value)){
			alert("숫자만 입력해야 합니다.");
			return false;
		}else if(user_phone.value.length != 11){
			alert("핸드폰 번호를 입력해 주세요. (길이가 맞지 않습니다.)");
			return false;
		}
		var quiz_direct = document.getElementsByName("quiz_direct");
		var user_quiz1 = document.getElementById("user_quiz1");
		var user_quiz = document.getElementById("user_quiz");
		if(quiz_direct[0].checked == true && user_quiz1.value == ""){
			alert("퀴즈를 내주세요");
			return false;
		}
		var user_name = document.getElementsByName("user_name");
		
		var user_name_value = document.getElementsByName("user_name")[0].value;
		
		var pattern_num = /[0-9]/;
		var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;
		var pattern_eng = /[a-z]/;
		if(pattern_num.test(user_name_value)||pattern_spc.test(user_name_value)||pattern_eng.test(user_name_value)){
			alert("이름은 한글만 입력 가능합니다.");
			return false;
		}
		var user_phone = document.getElementById("user_phone");
		var inputId2 = document.getElementById("inputId2");
		var user_answer = document.getElementsByName("user_answer");
		
		var check_gender;
		for(var i = 0; i<gender.length; i++){
			if(gender[i].checked == true){
				check_gender = gender[i].value;
			}
		}
		
		xhr= new XMLHttpRequest();
		xhr.onreadystatechange=getform;
		xhr.open('post','${cp}/Users.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('login_id='+inputId2.value+'&login_pwd='+inputPwd.value+'&user_name='+user_name[0].value+
				'&year='+year[0].value+'&month='+month[0].value+'&date='+date[0].value+
				'&user_gender='+check_gender+'&user_quiz='+user_quiz.value+
				'&user_quiz1='+user_quiz1.value+'&quiz_direct='+quiz_direct[0].checked+'&user_answer='+user_answer[0].value+
				'&user_phone='+user_phone.value);
	}
	function getform(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var code = xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			var inputId1 = document.getElementById("inputId2");
			var inputPassword = document.getElementById("inputPwd");
			if(code == "success"){
				location.href='${cp}/SendLogin.do?loginId='+inputId1.value+'&loginPwd='+inputPassword.value;
			}
		}
	}
	
	// 문제 직접 선택일 경우 바뀌는거
	function quiz_directa(num){
		var user_quiz = document.getElementById("user_quiz"); // 입력되어있는 칸
		var user_quiz1 = document.getElementById("user_quiz1"); // 입력해야하는 칸
		if(num == "1"){ // 직접입력 선택할 경우
			user_quiz.style.display = "none";
			user_quiz1.style.display = "inline-block";
			
		}else{
			user_quiz.style.display = "inline-block";
			user_quiz1.style.display = "none";
		}
	}
	var cnt = 0;
	// 전화번호 중복 확인
	function check_phone(){
		var pattern_num = /[0-9]/;
		var user_phone = document.getElementById("user_phone");
		if(user_phone.value == 0 || user_phone == null || user_phone == ""){
			alert("전화번호를 입력해주세요");
			return false;
		}else if(!pattern_num.test(user_phone.value)){
			alert("숫자만 입력해야 합니다.");
			return false;
		}else if(user_phone.value.length != 11){
			alert("핸드폰 번호를 입력해 주세요. (길이가 맞지 않습니다.)");
			return false;
		}
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=check_getPhone;
		xhr.open('get','${cp}/checkPhone.do?user_phone='+user_phone.value,true);
		xhr.send();
	}
	function check_getPhone(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var check_getPhone = xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			var join_user = document.getElementById("join_user");
			if(check_getPhone == "success"){
				alert("사용 가능한 전화번호 입니다.");
				cnt += 1;
				if(cnt >= 2){
					join_user.disabled="";
				}else{
					join_user.disabled="true";
				}
			}else{
				alert("이미 가입되어있는 전화번호 입니다.");
			}
		}
	}
	
	// 아이디 중복 확인
	function check_id(){
		var inputId2 = document.getElementById("inputId2").value;
		if(inputId2 == "" || inputId2 == null){
			alert("다시 입력해 주세요");
			return false;
		}else if(inputId2.length < 4){
			alert("아이디는 4자리 이상 입력해주세요");
			return false;
		}
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=check_getId;
		xhr.open('get','${cp}/checkId.do?inputId2='+inputId2,true);
		xhr.send();
	}
	
	function check_getId(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var check_getId = xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			var join_user = document.getElementById("join_user");
			if(check_getId == "success"){
				alert("사용 가능한 아이디 입니다.");
				cnt += 1;
				if(cnt >= 2){
					join_user.disabled="";
				}else{
					join_user.disabled="true";
				}
			}else{
				alert("사용 불가능한 아이디 입니다.");
			}
		}
	}
</script>
</body>
</html>