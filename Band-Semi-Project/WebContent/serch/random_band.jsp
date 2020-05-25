<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<br>
<br>
<br>
<br>
<br>
<br>
<style>
	.serch01
	{
		margin-left:200px; 
	}
</style>
<h2 class="serch01">이런	밴드는 어때요 <strong>${getcount }</strong></h2>
<button type="button" style="float:right;" onclick="location.href='${cp}/bandMore' ">더보기 ></button> 

<!--  <table border="2" width="1200">-->
<c:forEach var="vo" items="${random_list}" >
<table  class="serch01" style=" border:1px solid white;  "  >
	
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
 		<td  colspan="1" rowspan="4"><img src="${vo.bandimg }" style="height: 100px;"></td>
 		<td colspan="8" ><strong>밴드이름: ${vo.band_name}</strong></td>
	</tr >
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
		<td colspan="8" >밴드소개글: ${vo.band_intoroductio}</td>
	</tr>
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
		<td colspan="8" >멤버수:${vo.bandcnt } &nbsp;   리더:${vo.bandLeader }</td>
	</tr>
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
		
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
		
	</tr>
</table>
</c:forEach>

