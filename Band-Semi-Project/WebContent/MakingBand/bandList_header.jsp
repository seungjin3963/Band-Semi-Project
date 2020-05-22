<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${cp }/MakingBand/css_makeband/band_header.css">
<script>
function noSpaceForm(){                        
   	var keyword=document.getElementById("bandList2");
   
   	var keyword2=keyword.value.replace(/ /g,"");//  정규식:/ /사이에 있는 모든것 지움
   	if(keyword2=="" || keyword2==null){
   		keyword.value=null;
   		return false;
   	}else{
   		keyword.value=keyword.value.trim();
   		return true;
   	}
   	
}
window.addEventListener('load',function(){
	var on=false;

	var mypage=document.getElementById("mypage");
	
	var triangle=document.getElementById("bandList_triangle");
	var div2=document.getElementById("div2_makeband");
	
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
<div id="bandListheader">
<fieldset id="bandList4">
	<a href="${cp }/SendLogin.do" id="a1">
		&nbsp BAND &nbsp 
	</a>
</fieldset>
<form method="post" action="${cp }/bandSerch" id="bandList3" onsubmit="return noSpaceForm()">
	<input type="text" name="keyword" class="search-query" id="bandList2" placeholder="밴드명, 소개글 검색">
    	<button type="submit" class="bandList1"> <i class="icon-search"></i> </button>
</form>
<div id="div1_makeband">
	<button type="button" class="bandList1" id="mypage"><i class="icon-user"></i><i id="bandList_triangle">▼</i></button>
</div>

<div id="div2_makeband">
	<ul>
		<li class="bandList3"><a href="${cp }/MyPage.do" id="a1">마이페이지</a></li>
    	<li class="bandList3"><a href="${cp }/logout.do" id="a1">로그아웃</a></li>
    </ul>
</div>
</div>
