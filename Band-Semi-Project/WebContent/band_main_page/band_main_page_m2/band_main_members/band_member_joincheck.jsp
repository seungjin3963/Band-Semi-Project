<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.memberscheck{width: 100%;height: auto;border:1px solid black;}
	.memberscheck_div{width: 70%; height: auto; border: 1px black; margin: auto;}
	.memberscheck_div h4{float: left;}
	.listbandname_input{float: right; margin-right: 20px;}
</style>
</head>
<body>
<div class="memberscheck">
	<h3>가입 신청자</h3>
	<div class="memberscheck_div">
	<br>
	<br>
	<p>가입신청을 확인해주세요. 한 달이 지난 가입신청은 자동 거절 됩니다.</p>
	</div>
	<br>
	<br>
			<c:forEach var="vo" items="${requestScope.list }">
				<br>
				<div class="listbandname">
					<input type="button" value="승인" class="listbandname_input" onclick="approvalYes('${vo }')">
					<input type="button" value="거절" class="listbandname_input" onclick="approvalNo('${vo }')">
					<div class="listbandname_div"></div>
					<h4>${vo }</h4>
				</div>
				<br>
			</c:forEach>
</div>
<script type="text/javascript">
	
	var xhr=null;
	function approvalYes(name) {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=approvalyes;
		xhr.open('get','<%=request.getContextPath()%>/approvalyes.do?name='+name+''${b_n},true);
		xhr.send();
	}
	function approvalyes() {
		if(xhr.readyState==4 && xhr.status==200){
			alert("승인이 완료되었습니다");	
		}
	}
	
	function approvalNo(name) {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=approvalno;
		xhr.open('get','<%=request.getContextPath()%>/approvalno.do?name='+name,true);
		xhr.send();
	}
	function approvalno() {
		if(xhr.readyState==4 && xhr.status==200){
			alert("승인이 거절되었습니다");	
		}
	}
</script>
</body>
</html>