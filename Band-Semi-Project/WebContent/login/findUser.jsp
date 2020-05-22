<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/login/login_css/findUser_css.css">
<link href="${cp }/Resources/css/bootstrap.min.css" rel="stylesheet">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="./Resources/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function aacc(){
	// 아이디 찾기 ajax로 해야함
		var code1 ='${code1}'
			if(code1 != null){
				if(code1 == "fail"){
					alert("답이 틀렸습니다.");
				}else{
					var searchPwd = document.getElementById("searchPwd");
					searchPwd.innerHTML = code1;
				}
			}
	
	}	
	// 입력안하고 확인할 경우
	var xhr = null;
	
	function find_id(){
		var year = document.getElementsByName("year")[0].value;
		var month = document.getElementsByName("month")[0].value;
		var date = document.getElementsByName("date")[0].value;
		var name = document.getElementsByName("name")[0].value;
		if(year=="연도"||month==0||date==0||name==""){
			alert("다시 입력해 주세요");
		}
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getId;
		xhr.open('post','${cp}/findId.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('year='+year+'&month='+month+'&date='+date+'&name='+name);
	}
	
	function getId(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseXML;
			var div = document.getElementById("findid_div");
			var id = xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			if(id == "fail"){
				alert("가입되지 않은 회원입니다.");
				return false;
			}
			div.innerHTML = id;
		}		
	}
	
	function find_quiz(a){
		var year = document.getElementsByName("year")[1].value;
		var month = document.getElementsByName("month")[1].value;
		var date = document.getElementsByName("date")[1].value;
		var name = document.getElementsByName("name")[1].value;
		var id = document.getElementsByName("id")[0].value;
		if(year=="연도"||month==0||date==0||name==""||id==""){
			alert("다시 입력해 주세요");
		}
		a.onclick=null;
		console.log(a.onclick);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=getQuiz;
		xhr.open('post','${cp}/findQuiz.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('year='+year+'&month='+month+'&date='+date+'&name='+name+'&id='+id);
	}
	
	function getQuiz(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml = xhr.responseText;
			var json = JSON.parse(xml);
			var quiz = document.getElementById("quiz");
			var form = document.createElement("form");
			form.setAttribute("method", "Post");	// form method추가
			
			var hiddenId = document.createElement("input"); // hidden으로  id 보내기
			hiddenId.setAttribute("type", "hidden");
			hiddenId.setAttribute("name","login_id");
			hiddenId.value = json.login_id;
			var quest1 = document.createTextNode("퀴즈: ");	// 보여지는 text
			
			var user_quiz = document.createElement("span");	
			
			user_quiz.innerText = json.user_quiz;
			if(user_quiz.innerText == "undefined"){
				alert("존재하지 않는 회원입니다.");
				return false;
			}
			var br = document.createElement('br');
			
			var quest2 = document.createTextNode("답: ");
			
			var answer = document.createElement("input");
			answer.setAttribute("type", "text");
			answer.setAttribute("name","answer");
			
			quiz.appendChild(form);
			form.appendChild(hiddenId);
			form.appendChild(quest1)
			form.appendChild(user_quiz);
			form.appendChild(br);
			form.appendChild(quest2);
			form.appendChild(answer);
			
			var button = document.createElement("input");
			button.setAttribute("id","btn");
			button.setAttribute("type","submit");
		 	button.setAttribute("formaction",'${cp}/findPwd.do');
			button.value = "확인";
			
			form.appendChild(button);
		}
	}	
	
</script>
<body onload="aacc()" id="body">
<!-- style="text-align: center;" -->
						<!-- 아이디 찾기 -->
<div id="div_findUser" class="container show-grid">											<!-- 전체 감싸는 div -->
	<div class="row">

	<div class="col-md-6">			<!-- 아이디만 감싸는 div 1 -->
		<div id="div_find_id" class="col-md-6 col-md-offset-5">						<!-- 아이디 감싸는 div 2 -->
			<form method="post">
				<h4>아이디 찾기</h4>
				<label>이름</label>
				<input type="text" name="name">
				<br>
				
				<label>생년월일</label>
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
				<input type="button" value="확인" onclick="find_id()">
			</form>
			<div id="findid_div"></div>
		</div>
	</div>
		
								<!-- 비밀번호 찾기 -->
	<div class="col-md-6">		<!-- 비밀번호 감싸는 div -->
		<div id="div_find_pwd" class="col-md-6 col-md-offset-1">					<!-- 비밀번호 감싸는 div -->
			<h4>비밀번호 찾기</h4>
			<form method="post" >
				<label>아이디</label>
				<input type="text" name="id"><br>
				<label>이름</label>
				<input type="text" name="name">
				<br>
				
				<label>생년월일</label>
				<select name="year" id="year">
					<option>연도</option>
						<c:forEach var="i" begin="1920" end="2015">
							<option value="${i }">${i }</option>
						</c:forEach>
				</select>
				<select name="month" id="month">
					<option value="0">월</option>
						<c:forEach var="i" begin="1" end="12">
							<option value="${i }">${i }</option>
						</c:forEach>
				</select>
				<select name="date" id="date">
					<option value="0">일</option>
						<c:forEach var="i" begin="1" end="31">
						<option value="${i }">${i }</option>
					</c:forEach>
				</select>
				<input type="button" value="확인" onclick="find_quiz(this);"/>
				<div id="quiz"></div>
				<div id="searchPwd"></div>
			
			</form>
			<br>
		</div>
	</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<a id="go_main" class="col-md-4 col-md-offset-4" style="text-align: center;" href="${cp }/login/login.jsp">메인으로 돌아가기</a>
	</div>
</div>
</body>
</html>