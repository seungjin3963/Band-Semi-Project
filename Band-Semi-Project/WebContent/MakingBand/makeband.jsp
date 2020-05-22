<%@page import="java.util.ArrayList"%>
<%@page import="jhth.band.vo.MakeBandVo.CoverVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="makeband_cover">
	<div>
		<h2 id="bandname">밴드 이름</h2>
		<form style="width: 1300px; height: 1000px;" method="post"
			action="<%=request.getContextPath()%>/makeband_end.do">
			<div class="group">
				<input type="text" placeholder="밴드 이름 입력" id="textinput"
					name="bandname">
			</div>
			<div>
					<div style="width: 500px; height: 270px;float:left">
					<img src="MakingBand/bandcover/1.jpg" id="bcover"
						style="width: 500px; height: 280px;"> <input type="hidden"
						value="" id="bandcoverimg" name="bandcover"> <input
						type="hidden" value="${ sessionScope.login_num }" name="loginnum">
						</div>
					<div style="width: 750px; float:left; margin-left: 20px;">
						<div>
							커버선택 <span id="c_page">1</span> /2 <span> <input
								type="button" id="c_befor" value="<"> <input
								type="button" id="c_next" value=">">
							</span>
						</div>
						<c:forEach var="cover" items="${requestScope.cover }">
							<div style="width: 180px; height: 130px; display: inline-block;">
								<img src="${cover.coverURL }"
									style="width: 160px; height: 110px; margin: 10px;"
									class="imgURL" onclick="cover(${cover.covercount},this.src)">
							</div>
						</c:forEach>
					</div>
			</div>
			<p>
				<textarea rows="10" cols="1000" name="bandintroduct"
					placeholder="간단하게 밴드 소개글을 적어 주세요"
					style="margin-top: 10px; width: 1232px; height: 142px; resize: none; border: 1px solid black;"></textarea>
			</p>
			<div>
				<div class="block" id="selopen">
					<input type="radio" value="3" name="open"> <strong>비공개
						밴드</strong><br> 밴드와 게시글이 공개되지 않습니다. 초대를 통해서만 가입할 수 있습니다.
				</div>
				<div class="block" id="selopen">
					<input type="radio" value="2" name="open"> <strong>밴드명
						공개 밴드</strong><br> 누구나 밴드를 검색으로 찾아 밴드 소개를 볼 수 있지만, 게시글은 멤버만 볼 수 있습니다.
				</div>
				<div class="block" id="selopen">
					<input type="radio" value="1" name="open"> <strong>공개
						밴드</strong><br> 누구나 밴드를 검색해 찾을 수 있고, 밴드 소개와 게시글을 볼 수 있습니다.
				</div>
			</div>
			<input type="hidden" value="${requestScope.scategory}" name="scategory">
			<div id="selec">
				<input type="submit" value="완료" id="c_submit"> <input
					type="reset" value="취소" id="c_reset">
			</div>
		</form>
	</div>
</div>
<script>
var next=document.getElementById("c_next");
var befor=document.getElementById("c_befor");
var num=document.getElementById("c_page");
var coverURL=document.getElementsByClassName("imgURL");
var xhr=null;

next.addEventListener("click",function (){
    xhr=new XMLHttpRequest();
	xhr.onreadystatechange=page;
	xhr.open('get','${cp }/bandcover.do?coverpage='+9,true);
	xhr.send();
	num.innerHTML=2;
});

befor.addEventListener("click",function (){
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=page;
	xhr.open('get','${cp }/bandcover.do?coverpage='+1,true);
	xhr.send();
	num.innerHTML=1;
});

function page(){
	if(xhr.readyState==4 && xhr.status==200){
		var xml=xhr.responseText;
		var json=JSON.parse(xml);
		for(var i=0;i<8;i++){
			coverURL[i].src=json[i].url;
		}
	}
}

function cover(covercount,coverurl) {
	var bcover=document.getElementById("bcover");
	var bandcoverimg=document.getElementById("bandcoverimg");
	
	var arraycover=coverurl.split('/');
	var covernum=arraycover[6].split('.');
	
	bcover.src=coverURL[covercount].src;
	bandcoverimg.value=covernum[0];
}

</script>