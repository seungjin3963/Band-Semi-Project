<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.newCalenderdiv{border: 1px solid black; width: 100%; height:80px; margin-top: 20px;}
</style>
<script type="text/javascript">

var xhr=null;
var b=0;
function getCalenderList() {
	var year=document.getElementById("year").innerHTML;
	var month=document.getElementById("month").innerHTML;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=Calendercollback;
	xhr.open('get','<%=request.getContextPath()%>/band_main_page/band_main_page_m2/Calender/calender_ajax.jsp?year='+year+'&month='+month+'&num=${b_n}',true);
	xhr.send();
}
function Calendercollback() {
	if(xhr.readyState==4 && xhr.status==200){
		var xml=xhr.responseXML;
		var calendertitle=xml.getElementsByTagName("calendertitle");
		var calenderdate=xml.getElementsByTagName("calenderdate");
		var calendercontent=xml.getElementsByTagName("calendercontent");
		for (var i = 0; i < calendertitle.length; i++) {
			var caldate=parseInt(calenderdate[i].firstChild.nodeValue)+b;
			
			var calenderTd=document.getElementById("div"+caldate);
				calenderTd.innerHTML+="<br>"+calendertitle[i].firstChild.nodeValue;
			var calender=document.getElementsByClassName("calender")[0];
			var newCalenderdiv=document.createElement("div");
				calender.appendChild(newCalenderdiv);
				newCalenderdiv.className="newCalenderdiv";
			var newCalenderh1=document.createElement("h4");
			var newCalenderText=document.createTextNode(calenderdate[i].firstChild.nodeValue+"일      제목:"+calendertitle[i].firstChild.nodeValue+"   내용:"+calendercontent[i].firstChild.nodeValue);
				newCalenderdiv.appendChild(newCalenderh1);
				newCalenderh1.appendChild(newCalenderText);	
				
		}
	}
}
function getDate() {
	for (var i = 1; i < 42; i++) {
		var aaa=document.getElementById("div"+i);
		aaa.innerHTML="";
	}
	var lastmonth=0;
	var year=document.getElementById("year").innerHTML;
	var month=document.getElementById("month").innerHTML;
	var d=new Date(year+"/"+month+"/"+1).getDay();
	switch (parseInt(month)) {
	case 1: lastmonth=31;break;
	case 2:	lastmonth=28;break;
	case 3:	lastmonth=31;break;
	case 4:	lastmonth=30;break;
	case 5:	lastmonth=31;break;
	case 6:	lastmonth=30;break;
	case 7:	lastmonth=31;break;
	case 8:	lastmonth=31;break;
	case 9:	lastmonth=30;break;
	case 10:lastmonth=31;break;
	case 11:lastmonth=30;break;
	case 12:lastmonth=31;break;
	}
	var a=0;
	for (var i = 0; i < d; i++) {	
		a+=1;
	}
	b=a;
	for (var i = 1; i < lastmonth+1; i++) {
		var f=i+a;
		var aa=document.getElementById("div"+f);
		aa.addEventListener('mousemove',function(e){
			e.target.style.border="2px solid green";
		})
		aa.addEventListener('mouseout',function(e){
			e.target.style.border="";
		})
		aa.addEventListener('click',function(e){
			 $("#rladudshmodal").modal("show"); 
			 var calender_c_date=document.getElementById("calender_c_date");
			 var year=document.getElementById("year").innerHTML;
			 var month=document.getElementById("month").innerHTML;		
			 var s = e.target.innerHTML;
			 var day= s.split("<br>");
			 console.log(day[0]);
			 if(month<10){
			 	if(day[0]<10){
				 calender_c_date.value=year+"-0"+month+"-0"+day[0];
			 	}else{
			 	calender_c_date.value=year+"-0"+month+"-"+day[0];
			 	}
			 	
			 }else{
				 if(day[0]<10){
					 calender_c_date.value=year+"-"+month+"-0"+day[0];
				 	}else{
				 	calender_c_date.value=year+"-"+month+"-"+day[0];
				 	}
			 }
			
		})
		aa.innerHTML=i;	
		}
	
}


function calenderremove() {
	
	var calender=document.getElementsByClassName("calender")[0];
	var newCalenderdiv = document.getElementsByClassName("newCalenderdiv"); 
	console.log(newCalenderdiv.length);
	for (var i =  newCalenderdiv.length; i >0 ; i--) {
		calender.removeChild(newCalenderdiv[i-1]);
	}
}
</script>
<%
	Calendar cal = Calendar.getInstance();
	int Year=cal.get(Calendar.YEAR);
	int Month=cal.get(Calendar.MONTH)+1;
%>
</head>
<body>
	<div class="calender">
		<div id="calender_year">
			 <button  id="calenderbtn" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#rladudshmodal" >일정 추가</button>
			<input type="button" id="btn1" value="<">
			<h1 id="year"><%=Year %></h1><h1>년</h1>
			<input type="button" id="btn2" value=">">&nbsp;&nbsp;&nbsp;
			<input type="button" id="btn3" value="<">
			<h1 id="month"><%=Month %></h1><h1>월</h1>
			<input type="button" id="btn4" value=">">
		</div>
		<br>
		<div id="calender_day">
			<ul >
				<li>일</li>
				<li>월</li>
				<li>화</li>
				<li>수</li>
				<li>목</li>
				<li>금</li>
				<li>토</li>
			</ul>
		</div>
		<div id="calender_day_day">
			<table >
				<tr>
					<td id="div1" class="red"></td>
					<td id="div2"></td>
					<td id="div3"></td>
					<td id="div4"></td>
					<td id="div5"></td>
					<td id="div6"></td>		
					<td id="div7" class="bule"></td>		
				</tr>
				<tr>
					<td id="div8" class="red"></td>
					<td id="div9"></td>
					<td id="div10"></td>
					<td id="div11"></td>
					<td id="div12"></td>
					<td id="div13"></td>
					<td id="div14" class="bule"></td>				
				</tr>
				<tr>
					<td id="div15" class="red"></td>
					<td id="div16"></td>
					<td id="div17"></td>
					<td id="div18"></td>
					<td id="div19"></td>
					<td id="div20"></td>
					<td id="div21" class="bule"></td>				
				</tr>
				<tr>
					<td id="div22" class="red"></td>
					<td id="div23"></td>
					<td id="div24"></td>
					<td id="div25"></td>
					<td id="div26"></td>
					<td id="div27"></td>
					<td id="div28" class="bule"></td>				
				</tr>
				<tr>
					<td id="div29" class="red"></td>
					<td id="div30"></td>
					<td id="div31"></td>
					<td id="div32"></td>
					<td id="div33"></td>
					<td id="div34"></td>
					<td id="div35" class="bule"></td>				
				</tr>
				<tr>
					<td id="div36" class="red"></td>
					<td id="div37"></td>
					<td id="div38"></td>
					<td id="div39"></td>
					<td id="div40"></td>
					<td id="div41"></td>
					<td id="div42" class="bule"></td>				
				</tr>
				
			</table>
			
		</div>
	</div>
<div class="container">
  <div class="modal fade" id="rladudshmodal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">일정 추가</h3>
        </div>
        <div class="modal-body">
          <h4>일정 제목</h4>
          <form action="<%=request.getContextPath() %>/calender_insert"> 
          <input type="text" name="calender_title" required><br>
          <input type="hidden" value="${ck_n}" name="cknum"> 
          <h4>일정 상세 설명</h4>
         
          <textarea rows="5" cols="70" name="calender_content" required></textarea>
          
          <h4>켈린더</h4>
          
          <input type="date" name="calender_date" required id="calender_c_date"><br><br>
          <input type="submit" value="저장">
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>   
    </div>
  </div> 
  <br>
  <br>
  <br>
  <br>
</div>
</body>
<script type="text/javascript">
	getDate();
	getCalenderList();
		var year=document.getElementById("year");
		var month=document.getElementById("month");
	
	var btn1=document.getElementById("btn1");
	btn1.addEventListener('click',function(){
		year.innerHTML=parseInt(year.innerHTML)-1;		
		calenderremove();
		getDate();
		getCalenderList();
	});
	var btn2=document.getElementById("btn2");
	btn2.addEventListener('click',function(){
		year.innerHTML=parseInt(year.innerHTML)+1;	
		calenderremove();
		getDate();
		getCalenderList();
	});
	var btn3=document.getElementById("btn3");
	btn3.addEventListener('click',function(){
		month.innerHTML=parseInt(month.innerHTML)-1;
		if(month.innerHTML==0){
			month.innerHTML=12;
			year.innerHTML=parseInt(year.innerHTML)-1;
		}
		calenderremove();
		getDate();
		getCalenderList();
	});	
	var btn4=document.getElementById("btn4");
	btn4.addEventListener('click',function(){
		month.innerHTML=parseInt(month.innerHTML)+1;
		if(month.innerHTML==13){
			month.innerHTML=1;
			year.innerHTML=parseInt(year.innerHTML)+1;
		}
		calenderremove();
		getDate();
		getCalenderList();
	});	
</script>
</html>