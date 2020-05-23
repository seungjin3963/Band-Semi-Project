<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${cp }/Resources/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./Resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
var temp=0;
	function check_input_new_pwd(){
		var input_now_pwd = document.getElementById("input_now_pwd");
		var input_new_pwd = document.getElementById("input_new_pwd");
		var input_new_pwdOk = document.getElementById("input_new_pwdOk");
		if(temp == 1){
			return true;
		}else{
			if(input_now_pwd.value == "" || input_now_pwd.value == null){
				alert("현재 비밀번호를 입력해 주세요");
				return false;
			}
			if(input_new_pwd.value == "" || input_new_pwd.value == null){
				alert("새로운 비밀번호를 입력해 주세요");
				return false;
			}
			if(input_new_pwdOk.value == "" || input_new_pwdOk.value == null){
				alert("비밀번호 확인을 입력해 주세요");
				return false;
			}
			if(input_new_pwd.value != input_new_pwdOk.value){
				alert("비밀번호 확인이 다릅니다.");
				return false;
			}
			if(${requestScope.joinVo.login_pwd } != input_now_pwd.value){
				alert("현재 비밀번호와 다릅니다.");
				return false;
			}
		}
		return true;
	}

	// 생일 바꿀 때
	var xhr = null;
	function change_birth(){	// 변경 눌렀을 때 밑에 div 나타나게 함
		var changebirth = document.getElementById("changebirth");
		changebirth.setAttribute("style","display: none");
	
		var form1 = document.getElementById("form1");
		form1.setAttribute("style","display: inline");
		
		var div1 = document.createElement("div");
		div1.setAttribute("class","col-md-5");
		
		var year_select = document.createElement("select");	// 연도 넣기
		year_select.setAttribute("id","year_select");
		year_select.setAttribute("name","year_select");
		for(var i = 1920; i<=2015; i++){
			var year_value = document.createElement("option");
			year_value.setAttribute("value",i);
			year_value.innerHTML=i;
			year_select.appendChild(year_value);
			if(year_value.value == ${year}){
				year_value.setAttribute("selected","selected");
			}
		}
		
		var month_select = document.createElement("select");
		month_select.setAttribute("id","month_select");
		month_select.setAttribute("name","month_select");
		for(var i = 1; i<=12; i++){
			var month_value = document.createElement("option");
			month_value.setAttribute("value",i);
			month_value.innerHTML=i;
			month_select.appendChild(month_value);
			if(month_value.value == ${month}){
				month_value.setAttribute("selected","selected");
			}
		}
		
		var date_select = document.createElement("select");
		date_select.setAttribute("id","date_select");
		date_select.setAttribute("name","date_select");
		for(var i = 1; i<=31; i++){
			var date_value = document.createElement("option");
			date_value.setAttribute("value",i);
			date_value.innerHTML = i;
			date_select.appendChild(date_value);
			if(date_value.value == ${date}){
				date_value.setAttribute("selected","selected");
			}
		}
		div1.appendChild(year_select);
		div1.appendChild(month_select);
		div1.appendChild(date_select);
		form1.appendChild(div1);
		
		var div2 = document.createElement("div");
		div2.setAttribute("class","col-md-2");
		
		var button1 = document.createElement("button");
		button1.setAttribute("class","btn btn-success btn-xs");
		button1.setAttribute("type","submit");
		button1.setAttribute("formaction","${cp}/Birth.do");
		button1.innerHTML = "확인";
		
		var button2 = document.createElement("button");
		button2.setAttribute("class","btn btn-success btn-xs");
		button2.setAttribute("type","submit");
		button2.setAttribute("value","취소");
		button2.setAttribute("formaction","${cp}/Cancle.do");
		button2.innerHTML = "취소";
		
		div2.appendChild(button1);
		div2.appendChild(button2); 
		form1.appendChild(div2);
	
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getBirth;
		xhr.open('post','${cp}/Birth.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('year='+year+'&month='+month+'&date='+date);
	}
	function getBirth(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var form1 = document.getElementById("form1");
			form1.setAttribute("style","display: none");
			
			var changebirth = document.getElementById("changebirth");
			changebirth.setAttribute("style","display: inline");
			
			var now_birth = document.getElementById("now_birth");
			if(update_birth == null){
				alert("변경이 잘못 되었습니다.");
				return false;
			}
		}
	}
	
	
	function change_gender(){	// 성별 바꿀 때
		var changegender = document.getElementById("changegender");
		changegender.setAttribute("style","display: none");
		
		var form2 = document.getElementById("form2");
		form2.setAttribute("style","display: inline");

		var div3 = document.createElement("div");
		div3.setAttribute("class","col-md-5");
		
		var radio_gender1 = document.createElement("input");
		radio_gender1.setAttribute("type", "radio");
		radio_gender1.setAttribute("name", "radio_gender");
		radio_gender1.setAttribute("value","w");
		
		var radio_gender2 = document.createElement("input");
		radio_gender2.setAttribute("type", "radio");
		radio_gender2.setAttribute("name", "radio_gender");
		radio_gender2.setAttribute("value","m");
		
		div3.appendChild(radio_gender1);
		div3.innerHTML +="여자";
		div3.appendChild(radio_gender2);
		div3.innerHTML +="남자";
		form2.appendChild(div3);
		
		var div4 = document.createElement("div");
		div4.setAttribute("class","col-md-2");
		
		var button1 = document.createElement("button");
		button1.setAttribute("class","btn btn-success btn-xs");
		button1.setAttribute("type","submit");
		button1.setAttribute("formaction","${cp}/Gender.do");
		button1.innerHTML = "확인";
		
		var button2 = document.createElement("button");
		button2.setAttribute("class","btn btn-success btn-xs");
		button2.setAttribute("type","submit");
		button2.setAttribute("formaction","${cp}/Cancle.do");
		button2.innerHTML = "취소";
		
		div4.appendChild(button1);
		div4.appendChild(button2);
		form2.appendChild(div4);
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getGender;
		xhr.open('get','${cp}/Gender.do?radio_value='+radio_value,true);
		xhr.send();
	}
	function getGender(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var form2 = document.getElementById("form2");
			form2.setAttribute("style","display: none");	

			var changegender = document.getElementById("changegender");
			changegender.setAttribute("style","display: inline");
			
			var now_gender = document.getElementById("now_gender");
			if(now_gender == null){
				alert("변경이 잘못 되었습니다.");
				return false;
			}
		}
	}
	function change_phone(){	// 핸드폰 번호 바꿀 때
		var changephone = document.getElementById("changephone");
		changephone.setAttribute("style","display: none");
		
		var form3 = document.getElementById("form3"); 
		form3.setAttribute("style","display: inline");
		
		var div5 = document.createElement("div");
		div5.setAttribute("class","col-md-5");
		
		var phoneNumber = document.createElement("input");
		phoneNumber.setAttribute("type","text");
		phoneNumber.setAttribute("name","phoneNumber");
		phoneNumber.setAttribute("placeholder","숫자만 입력해 주세요.");		
		
		div5.appendChild(phoneNumber);
		form3.appendChild(div5);
		
		var div6 = document.createElement("div");
		div6.setAttribute("class","col-md-2");
		
		var button1 = document.createElement("button");
		button1.setAttribute("class","btn btn-success btn-xs");
		button1.setAttribute("type","submit");
		button1.addEventListener("click",function(e){
			if(phoneNumber.value ==""||phoneNumber.value == null){
				alert("전화번호를 입력해 주세요.");
				return false;
			}else if(!pattern_num.test(phoneNumber.value)){
				alert("숫자만 입력해야 합니다.");
				return false;
			}else if(phoneNumber.value.length != 11){
				alert("핸드폰 번호를 입력해 주세요. (길이가 맞지 않습니다.)");
				return false;
			}
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange=getPhone;
			xhr.open('get','${cp}/Phone.do?phoneNumber='+phoneNumber.value,true);
			xhr.send();
		});
		button1.innerHTML = "확인";
		
		var button2 = document.createElement("button");
		button2.setAttribute("class","btn btn-success btn-xs");
		button2.setAttribute("type","submit");
		button2.setAttribute("formaction","${cp}/Cancle.do");
		button2.innerHTML = "취소";

		div6.appendChild(button1);
		div6.appendChild(button2);
		form3.appendChild(div6);
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getGender;
		xhr.open('get','${cp}/Phone.do?phoneNumber='+phoneNumber,true);
		xhr.send();
	}
	function getPhone(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var form3 = document.getElementById("form3");
			form3.setAttribute("style","display: none");	

			var now_phone = document.getElementById("now_phone");
			now_phone.setAttribute("style","display: inline");
		}
	}
	
	function change_email(){	// 이메일 바꿀 때
		var changeEmail = document.getElementById("changeEmail");
		changeEmail.setAttribute("style","display: none");
		
		var form4 = document.getElementById("form4"); 
		form4.setAttribute("style","display: inline");
		
		var div7 = document.createElement("div");
		div7.setAttribute("class","col-md-5");
		
		var Email = document.createElement("input");
		Email.setAttribute("type","text");
		Email.setAttribute("name","Email");
		Email.setAttribute("placeholder","이메일을 입력해 주세요.");	
		
		div7.appendChild(Email);
		form4.appendChild(div7);
		
		var div8 = document.createElement("div");
		div8.setAttribute("class","col-md-2");
		
		var button1 = document.createElement("button");
		button1.setAttribute("class","btn btn-success btn-xs");
		button1.setAttribute("type","submit");
		button1.addEventListener("click",function(e){
			if(Email.value =="" || Email.value == null){
				alert("이메일을 입력해 주세요.");
				return false;
			}else if(!pattern_email.test(Email.value)){
				alert("이메일을 입력해 주세요. (@가 없습니다.)");
				return false;
			}
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange=getPhone;
			xhr.open('get','${cp}/Email.do?Email='+Email.value,true);
			xhr.send();
		});
		button1.innerHTML = "확인";
		
		var button2 = document.createElement("button");
		button2.setAttribute("class","btn btn-success btn-xs");
		button2.setAttribute("type","submit");
		button2.setAttribute("formaction","${cp}/Cancle.do");
		button2.innerHTML = "취소";
		
		div8.appendChild(button1);
		div8.appendChild(button2);
		form4.appendChild(div8);
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getEmail;
		xhr.open('get','${cp}/Email.do?Email='+Email,true);
		xhr.send();
	}
	function getEmail(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var form4 = document.getElementById("form4");
			form4.setAttribute("style","display: none");	

			var now_email = document.getElementById("now_email");
			now_email.setAttribute("style","display: inline");			
		}
	}
	function change_pwd(){	 	// 비밀번호 바꿀 때
		var changepwd = document.getElementById("changepwd");
		changepwd.setAttribute("style","display: none");
		
		var form5 = document.getElementById("form5"); 
		form5.setAttribute("style","display: inline");
		
		var div9 = document.createElement("div");
		
		var div10 = document.createElement("div");
		div10.setAttribute("class", "col-md-5 col-md-offset-5");
		
		var div10_1 = document.createElement("div");
		div10_1.innerHTML = "현재 비밀번호 ";
		
		var input_now_pwd = document.createElement("input");
		input_now_pwd.setAttribute("type","text");
		input_now_pwd.setAttribute("id","input_now_pwd");
		div10_1.appendChild(input_now_pwd);
		
		var div10_2 = document.createElement("div");
		div10_2.innerHTML = "새 비밀번호 ";
		
		var input_new_pwd = document.createElement("input");
		input_new_pwd.setAttribute("type","text");
		input_new_pwd.setAttribute("name","input_new_pwd");
		input_new_pwd.setAttribute("id","input_new_pwd");
		div10_2.appendChild(input_new_pwd);
		
		var div10_3 = document.createElement("div");
		div10_3.innerHTML = "비밀번호 확인";
		
		var input_new_pwdOk = document.createElement("input");
		input_new_pwdOk.setAttribute("type","text");
		input_new_pwdOk.setAttribute("id","input_new_pwdOk");
		div10_3.appendChild(input_new_pwdOk);
		
		var div11 = document.createElement("div");
		div11.setAttribute("class","col-md-2");
		
		var button1 = document.createElement("button");
		button1.setAttribute("class","btn btn-success btn-xs");
		button1.setAttribute("type","submit");
		button1.setAttribute("formaction","${cp}/Pwd.do");
		button1.innerHTML = "확인";
		
		var button2 = document.createElement("button");
		button2.setAttribute("class","btn btn-success btn-xs");
		button2.setAttribute("type","submit");
		button2.setAttribute("formaction","${cp}/Cancle.do");
		button2.innerHTML = "취소";
		
		button2.addEventListener("click", function() {
			temp=1;
		});
		
		div10.appendChild(div10_1);
		div10.appendChild(div10_2);
		div10.appendChild(div10_3);
		div9.appendChild(div10);
		
		div11.appendChild(button1);
		div11.appendChild(button2);
		form5.appendChild(div9);
		form5.appendChild(div11);
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getPwd;
		xhr.open('get','${cp}/Pwd.do?input_new_pwd='+input_new_pwd,true);
	}
	function getPwd(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseText;
			var form5 = document.getElementById("form5");
			form5.setAttribute("style","display: none");	

			var changepwd = document.getElementById("changepwd");
			changepwd.setAttribute("style","display: inline");			
		}
	}
	function change_state(){	// 탈퇴할 때
		var result = confirm("정말 탈퇴하시겠습니까?");
		if(result){
			alert("탈퇴 되었습니다.");
			location.href="${cp}/Login_state.do";
		}
	}
</script>

<div class="container-fluid" style="width: 100%">
	<div class="row no-gutter">
		<h4>내 정보</h4>
		<div class="row">
			<!-- 사용중인 프로필 -->
			<div class="col-md-3" style="text-align: center;">사용중인 프로필</div>
			<!-- 밑에 div에 사진 -->
			<div class="col-md-2">
				<img src="">
			</div>
			<div class="col-md-5">${requestScope.joinVo.user_name }</div>
			<div class="col-md-2">
				<input class="btn btn-success btn-xs" type="button" value="변경"
					data-toggle="modal" data-target="#profileChange">
			</div>
		</div>
		<div class="row">
			<!-- 개인정보  -->
			<div class="col-md-3" style="text-align: center;">개인 정보</div>
			<div class="col-md-2">생일</div>

			<div id="birthInfo">
				<div class="col-md-5"></div>
				<div id="changebirth">
					<div class="col-md-5" id="now_birth">${requestScope.joinVo.user_birth }</div>
					<div class="col-md-2">
						<input class="btn btn-success btn-xs" type="button" value="변경"
							onclick="change_birth()">
					</div>
				</div>
				<form id="form1" method="post" style="display: hidden;"></form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-3">성별</div>

			<div id="genderInfo">
				<div class="col-md-5"></div>
				<div id="changegender">
					<div class="col-md-5" id="now_gender">
						<c:choose>
							<c:when test="${requestScope.joinVo.user_gender == 'w' }">
								여자
							</c:when>
							<c:when test="${requestScope.joinVo.user_gender == 'm' }">
								남자
							</c:when>
							<c:otherwise>
								null
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-2">
						<input class="btn btn-success btn-xs" type="button" value="변경"
							onclick="change_gender()">
					</div>
				</div>

				<form id="form2" method="post" style="display: hidden;"></form>
			</div>
		</div>
		<br>
		<div class="row">
			<!-- 로그인 계정 -->
			<div class="col-md-3" style="text-align: center;">로그인 계정</div>
			<div class="col-md-2">휴대폰 번호</div>

			<div id="phoneInfo">
				<div class="col-md-5"></div>
				<div id="changephone">
					<div class="col-md-5" id="now_phone">${requestScope.joinVo.user_phone }</div>
					<div class="col-md-2">
						<input class="btn btn-success btn-xs" type="button" value="변경"
							onclick="change_phone()">
					</div>
				</div>
				<form id="form3" method="post" style="display: hidden;"></form>
			</div>
		</div>
		<div class="row">
			<div id="emailInfo">
				<div class="col-md-2 col-md-offset-3">이메일</div>

				<div id="emailInfo">
					<div id="changeEmail">
						<div class="col-md-5" id="now_email">${requestScope.joinVo.user_email }</div>
						<div class="col-md-2">
							<input class="btn btn-success btn-xs" type="button" value="변경"
								onclick="change_email()">
						</div>
					</div>
					<form id="form4" method="post" style="display: hidden;"></form>
				</div>
			</div>
		</div>
		<div class="row">
			<div id="pwdInfo">
				<div class="col-md-2 col-md-offset-3">비밀번호</div>
				<div id="changepwd">
					<div class="col-md-5" id="now_pwd">${requestScope.joinVo.login_pwd }</div>
					<div class="col-md-2">
						<input class="btn btn-success btn-xs" type="button" value="변경"
							onclick="change_pwd()">
					</div>
				</div>

				<div id="pwdInfo2">
					<form id="form5" method="post" style="display: hidden;"
						onsubmit="return check_input_new_pwd()"></form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-3">탈퇴</div>
			<div class="col-md-2 col-md-offset-5">
				<input class="btn btn-success btn-xs" type="button" value="탈퇴"
					onclick="change_state()">
			</div>
		</div>
	</div>
	<br> <br>
</div>
<!-- 질문 
 --><div class="modal fade" id="profileChange" role="dialog" aria-labelledby="myCenterModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<form action="${cp }/upload.jsp" method="post"
					enctype="multipart/form-data" style="text-align: center;">
					<label for="selectimg"> 
					<img src="${cp }/MakingBand/bandcover/1.jpg"
						style="width: 130px; height: 130px; border-radius: 70%; overflow: hiddin;"
						id="profileimg">
					</label><br> <input type="text" name="nickname"
						style="margin-top: 10px;"><br> <input type="file"
						name="potofile" id="selectimg"
						accept="image/git, image/jpeg, image/png" style="display: none;">
					<input type="hidden" value="${sessionScope.login_num }"
						name="login_num"> <input type="submit" value="확인"
						style="margin-top: 10px; width: 100px; height: 40px; background-color: black; color: white;">
				</form>
			</div>
		</div>
	</div>
</div>
