<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bandMain.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
window.onload=function(){	
	makeband=document.getElementById("makeband");
	
/* 	makeband.addEventListener("mouseover", function() {
		makeband.style.boxShadow="5px 5px 5px 5px";
	});
 */
 
/* 	makeband.addEventListener("mouseout", function() {
		makeband.style.boxShadow="none";
	});
 */
 
 }
 	function inshodow(){
		makeband.style.boxShadow="5px 5px 5px 5px";
	}

 	function outshodow(){
		makeband.style.boxShadow="none";
 	}
</script>
<div id="bandList">
	<h2>내 목록</h2>
	<div>
		<a href="${cp }/category.do" id="a2">
			<div id="makeband" onmouseover="inshodow()"; onmouseout="outshodow()";>
				<div id=add>+</div>
				<fieldset>밴드 만들기</fieldset>
			</div>
		</a>
		<c:forEach var="list" items="${requestScope.bandlist }">
			<a href="${cp }/rladudsh.do?band_numnum=${list.band_num}&loginnum=${sessionScope.login_num}" id="a2" >
			
				<div style="display: inline-block; width: 180px; height: 200px; margin-left: 20px;" onmouseover="inshodow()" onmouseout="outshodow()">
					<img src="${list.bandimg }" style="width: 180px; height: 150px;"><br>
					<span>${list.bandname }</span><br>
					멤버:<span>${list.bandcount }</span>
				</div>
			</a>
		</c:forEach>
	</div>
</div>

