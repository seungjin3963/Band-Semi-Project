<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <style type="text/css">
	.serchCss2{width:400px;height:60px;  margin-bottom:25px; margin-left: 5px; }
	.serchCss1{width:60px;height:60px;  margin-bottom:25px; float:left;   }
	.fontCss1{font-weight:900;}
	.fontCss2{font-weight:400;  }
	.fontCss3{font-weight:50;color: gray;}
</style> 
<h1>세부카테고리 하위 밴드</h1>
 <input type="text" value="${category_stitle }에 속한 밴드들"> 
<br>
 <script type="text/javascript">
	var list = new Array(); 
</script>
<c:forEach var="vo" items="${list}" >
	<!-- <script type="text/javascript">
	list.push({band_name:"${vo.band_name}"
		,band_intoroductio:"${vo.band_intoroductio}"});
	</script> -->
	<table   style="width:800px; border:1px solid orange;  "  >
	
	<tr style = "cursor:pointer;" onClick = " location.href='' ">
		<td colspan="5" rowspan="4">사진</td>
		<td colspan="8" >밴드이름: ${vo.band_name}</td>
	</tr >
	<tr style = "cursor:pointer;" onClick = " location.href='' ">
		<td colspan="8" >밴드소개글: ${vo.band_intoroductio}</td>
	</tr>
	<tr style = "cursor:pointer;" onClick = " location.href='' ">
		<td colspan="8" >멤버수:   /   리더:</td>
	</tr>
	<tr style = "cursor:pointer;" onClick = " location.href='' ">
		
		<td colspan="8">밴드 더보기</td>
	</tr>
	<tr >
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		<td >&nbsp; </td>
		
	</tr>
</table>
</c:forEach>
<div>
	<div id="bandImg" style="">
		
	</div>
	<div id="bandList">
	
	</div>
</div>
<script type="text/javascript">
	var bandList=document.getElementById("bandList");

	
	for(var i=0;i<list.length;i++){
		console.log("테스트.jsp1");
		var div1=document.createElement("div");
		var div2=document.createElement("div");
		div1.innerHTML="밴드사진"
		div2.innerHTML="<span class='fontCss1'>밴드이름:"+list[i].band_name+"</span> <br>"+"<span class='fontCss2'>밴드소개글:"+list[i].band_intoroductio+"</span><br><span class='fontCss3'> 멤버수:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;밴드장:</span>";
		div1.className="serchCss1";
		div2.className="serchCss2";
		bandList.appendChild(div1);
		bandList.appendChild(div2);
		//console.log(list[i].band_name);
		//console.log(list[i].band_intoroductio);
	}
</script> 
