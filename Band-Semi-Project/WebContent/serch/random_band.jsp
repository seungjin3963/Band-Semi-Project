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
<h2 class="serch01">밴드·페이지  <strong>${getcount }</strong></h2>
<!--  <table border="2" width="1200">-->
<c:forEach var="vo" items="${random_list}" >
<table  class="serch01" style=" border:1px solid white;  "  >
	
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
<%-- 		<td colspan="5" rowspan="4"><img src="${vo.bandimg }" style="height: 100px;"></td>
 --%>		<td  colspan="1" rowspan="4"><img src="${vo.bandimg }" style="height: 100px;"></td>
 		<td colspan="8" ><strong>밴드이름: ${vo.band_name}</strong></td>
	</tr >
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
		<td colspan="8" >밴드소개글: ${vo.band_intoroductio}</td>
	</tr>
	<tr style = "cursor:pointer;" onClick = " location.href='${cp}/rladudsh.do?band_numnum=${vo.band_num}' ">
		<td colspan="8" >멤버수:   /   리더:</td>
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
<div class="serch01" >
<c:choose>
	<c:when test="${startPage>3 }">
		<a href="${cp }/bandSerch?pageNum=${startPage-1 }&keyword=${keyword}">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/bandSerch?pageNum=${i}&keyword=${keyword}">
				<span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/bandSerch?pageNum=${i}&keyword=${keyword}">
				<span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/bandSerch?pageNum=${endPage+1 }&keyword=${keyword}">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>

