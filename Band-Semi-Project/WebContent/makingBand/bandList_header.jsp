<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
window.addEventListener('load',function(){
	var on=false;

	var mypage=document.getElementById("mypage");
	
	var triangle=document.getElementById("bandList_triangle");
	var div2=document.getElementById("div2");
	
	mypage.addEventListener("click", function(e) {
		if(on == false){
			div2.style.display="block";

			triangle.innerHTML="▲";
			triangle.style.opacity= 1;
			
			on=true;
		}else{
			div2.style.display="none";

			triangle.innerHTML="▼";
			triangle.style.opacity= 0.5;
			
			on=false;
		}
	});
});
</script>
<div id="bandLisgheader">
<fieldset id="bandList4">
	<a href="" id="a1">
		&nbsp BAND &nbsp 
	</a>
</fieldset>
<form method="post" action="" id="bandList3">
	<input type="text" class="search-query" id="bandList2" placeholder="밴드명, 소개글 검색">
    	<button type="submit" class="bandList1"> <i class="icon-search"></i> </button>
</form>
<div id="div1">
	<button type="button" class="bandList1" id="mypage"><i class="icon-user"></i><i id="bandList_triangle">▼</i></button>
</div>

<div id="div2">
	<ul>
		<li class="bandList3"><a href="#" id="a1">마이페이지</a></li>
    	<li class="bandList3"><a href="#" id="a1">로그아웃</a></li>
    </ul>
</div>
</div>
