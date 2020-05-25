<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bandMain.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
 	function inshodow(band){
 		var choose = document.getElementById(band);
 		choose.style.boxShadow="3px 3px 3px 3px #999";
	}

 	function outshodow(band){
 		var choose = document.getElementById(band);
 		choose.style.boxShadow="none";
 	}
</script>
<div id="bandList_sel">
	<h2>내 목록</h2>
	<div>
		<a href="category.do" id="a2">
			<span id="add" onmouseover="inshodow(this.id)"; onmouseout="outshodow(this.id)" style="font-size: 120px;">
					+
			</span>
		</a>
		<c:forEach var="list" items="${requestScope.bandlist }">
			<a href="${cp }/rladudsh.do?band_numnum=${list.band_num }" id="a2" >
				<div class="join_band" id="joinband${list.band_num }" onmouseover="inshodow(this.id)" onmouseout="outshodow(this.id)">
					<img src="${list.bandimg }" style="width: 180px; height: 149px;"><br>
					<span>${list.bandname }</span><br>
					<span id="membersoo">멤버:${list.bandcount }</span>
				</div>
			</a>
		</c:forEach>
	</div>
</div>

