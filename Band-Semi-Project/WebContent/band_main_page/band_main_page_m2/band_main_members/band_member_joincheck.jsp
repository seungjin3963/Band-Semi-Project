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
					<input type="button" value="승인" class="listbandname_input" onclick="approvalYes('${vo.getName() }','${vo.getUser_num() }')">
					<input type="button" value="거절" class="listbandname_input" onclick="approvalNo('${vo.getName() }','${vo.getUser_num() }')">
					<div class="listbandname_div"><img src="${cp }/userprofile.do?userprofile=${vo.getUser_num() }"></div>
					<h4>${vo.getName() }</h4>
					
					
				</div>
				<br>
			</c:forEach>
</div>
<script type="text/javascript">
	
	var xhr=null;
	function approvalYes(name,user_num) {
		
		location.href ="<%=request.getContextPath()%>/approvalyes.do?name="+name+"&num="+user_num;
	
	}
	
	
	function approvalNo(name,user_num) {
		
		location.href ="<%=request.getContextPath()%>/approvalno.do?name="+name+"&num="+user_num;
	}
	
</script>
</body>
</html>