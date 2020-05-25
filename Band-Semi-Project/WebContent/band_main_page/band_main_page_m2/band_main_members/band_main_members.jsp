<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>

<div class="bandmemberslist">
	<div class="bandmemberslist_h">
		<ul>	
		
			<li>맴버</li>
			<li>맴버 인원수</li>
		</ul>
	</div>
		<br>
			<input type="text" class="input-group" placeholder="맴버 검색" id="band_selecttext">&nbsp;
			<button class="input-group-btn" onclick="aaa()">
	   		 <i class="icon-search" ></i>
	   	 </button>
	   	 <br>
	   	 <br>
	   	
	   		<input type="button" value="가입 신청자>" onclick="checkmembers()">
	   	
	   	<br>
	   	<br>
	<div class="bandmemberslist_m">
		<div class="bandmemberslist_m_h">
			<h3>맴버 </h3>
			<select id="band_selectoption">
				<option value="1">이름 순</option>
				<option value="2">밴드 가입순</option>
			</select>
				<br>
				<br>
			<c:forEach var="vo" items="${requestScope.list }">
				<br>
				<div class="listbandname">
					<div class="listbandname_div"><!--<img src="${cp }/userprofile.do?userprofile=${vo.getUser_num() }">--></div>
					<h4>${vo.getName() }</h4>
				</div>
			</c:forEach>
			</div>
			<br>
			<br>
			<br>
			<br>
	</div>
</div>
	
</body>
<<script type="text/javascript">
	
	function aaa() {
		var selecttext=document.getElementById("band_selecttext").value;
		var selectoption=document.getElementById("band_selectoption").value;
		location.href="<%=request.getContextPath()%>/members_like_select?selecttext="+selecttext+"&selectoption="+selectoption;
	}
	
	function checkmembers() {
		location.href="<%=request.getContextPath()%>/membersjoinOk.do";
	}
</script>
</html>













