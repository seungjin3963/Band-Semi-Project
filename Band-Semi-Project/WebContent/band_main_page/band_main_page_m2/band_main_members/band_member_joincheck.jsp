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
					<input type="button" value="승인" class="listbandname_input" onclick="approvalYes('${vo.getName() }','${vo.getUser_num() }'),'${vo.getDivdelete() }'">
					<input type="button" value="거절" class="listbandname_input" onclick="approvalNo('${vo.getName() }','${vo.getUser_num() }'),'${vo.getDivdelete() }'">
					<div class="listbandname_div"></div>
					<h4>${vo.getName() }</h4>
					<h4>${vo.getName() }</h4>
				</div>
				<br>
			</c:forEach>
</div>
<script type="text/javascript">
	
	var xhr=null;
	function approvalYes(name,user_num , divnum) {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=approvalyes;
		xhr.open('get','<%=request.getContextPath()%>/approvalyes.do?name='+name+'&num='+user_num,true);
		xhr.send();
	}
	function approvalyes() {
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseXML;
			var update=xml.getElementsByTagName("update")[0].firstChild.nodeValue;
		 	//var memberscheck_div=document.getElementsByClassName("memberscheck_div")[0];
		 	//var deletediv=document.getElementsByClassName("listbandname")[divnum-1];
		 	//memberscheck_div.removeChild(deletediv);
			alert(update);
		}
	}
	
	
	
	
	function approvalNo(name,user_num, divnum) {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=approvalno;
		xhr.open('get','<%=request.getContextPath()%>/approvalno.do?name='+name+'&num='+user_num,true);
		xhr.send();
	}
	function approvalno() {
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseXML;
			var deleted=xml.getElementsByTagName("deleted")[0].firstChild.nodeValue;
			alert(deleted);
		}
	}
</script>
</body>
</html>