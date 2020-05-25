<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<button type="button" style="float:right;" onclick="location.href='${cp}/bandMore' ">더보기 ></button> 
<%-- <a href="${cp }/bandMore">더보기</a>
 --%><!-- a태그 링크 --> 
<style type="text/css">
	.random_css1{width:60px;height:60px;  margin-bottom:25px;  clear: both;   }
 	.random_css2{width:200px;height:60px;  margin-bottom:25px; margin-left: 25px; float: left; }
	.random_css3{width:60px;height:60px;  margin-bottom:25px; float: left;   }
	.random_css4{width:200px;height:60px;  margin-bottom:25px; margin-left: 25px; float: left; }
	.fontCss1{font-weight:900;}
	.fontCss2{font-weight:400;}
	.fontCss3{font-weight:50;color: gray;}
	/* .bL1{width:600px;height:600px; margin-left: 100px};
	 .bL2{width:600px;height:600px; margin-left: 300px};  */
</style>

<h1>이런 밴드는 어때요</h1>
<br>
<script type="text/javascript">
	var list = new Array(); 
</script>
<c:forEach var="vo" items="${random_list}" >
	<script type="text/javascript">
	list.push({band_name:"${vo.band_name}"
		,band_intoroductio:"${vo.band_intoroductio}"
		,band_num:"${vo.band_num}"
		,bandimg:"${vo.bandimg}"});
	</script>
</c:forEach>

<div >
	<div id="bandList1" class="bL1"></div>
</div>
<script type="text/javascript">

	var bandList1=document.getElementById("bandList1");
	var bandList2=document.getElementById("bandList2");
	var cnt=0;
	for(let i=0;i<list.length;i++){
		//console.log(list[i].band_num);
		if(i%2==0){
			var div11=document.createElement("div");
			var div22=document.createElement("div");
			var img=document.createAttribute("img");
			img.src='${list[i].bandimg}';
			div11.innerHTML="밴드사진"
			div22.innerHTML="<span class='fontCss1'>밴드이름:"+list[i].band_name+"</span> <br>"+"<span class='fontCss2'>밴드소개글:"+list[i].band_intoroductio+"</span><br><span class='fontCss3'> 멤버수:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;밴드장:</span>";
			div11.className="random_css1";
			div22.className="random_css2";
			div11.style="cursor:pointer";
			div22.style="cursor:pointer";
			//div11.onclick=" location.href='${cp}/rladudsh.do?band_numnum='"+list[i].band_num ;
			//div22.onclick=" location.href='${cp}/rladudsh.do?band_numnum='"+list[i].band_num ;
			div22.addEventListener("click",function(e){
				//console.log(list[i].band_num);
				location.href='${cp}/rladudsh.do?band_numnum='+list[i].band_num;
			});
			div11.addEventListener("click",function(e){
				location.href='${cp}/rladudsh.do?band_numnum='+list[i].band_num;
			});
			 /* if(cnt%4==0){
				//	.random_css1{width:60px;height:60px;  margin-bottom:25px; float: left;   }
				div11.style.width="60px";
				div11.style.height="60px";
				div11.style.marginBottom="25px";
				div11.style.float = "left";
				div11.style.display="inline";
			}else{
				div11.style.width="60px";
				div11.style.height="60px";
				div11.style.marginBottom="25px";
				div11.style.clear="both";
				div11.style.display="block";
			}
			cnt+=1; */ 
			bandList1.appendChild(div11);
			bandList1.appendChild(div22);
			//console.log(list[i].band_name);
			//console.log(list[i].band_intoroductio);
		}else{
			var div33=document.createElement("div");
			var div44=document.createElement("div");
			div33.innerHTML="밴드사진"
			div44.innerHTML="<span class='fontCss1'>"+list[i].band_name+"</span> <br>"+"<span class='fontCss2'>밴드소개글:"+list[i].band_intoroductio+"</span><br><span class='fontCss3'> 멤버수:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;밴드장:</span>";
			div33.className="random_css3";
			div44.className="random_css4";
			var img1=document.createAttribute("img1");
			img1.src='${list[i].bandimg}';
			//div33.onclick=" location.href='${cp}/rladudsh.do?band_numnum='"+list[i].band_num ;
			//div44.onclick=" location.href='${cp}/rladudsh.do?band_numnum='"+list[i].band_num ;
			div33.style="cursor:pointer";
			div44.style="cursor:pointer";
			div33.addEventListener("click",function(e){
				location.href='${cp}/rladudsh.do?band_numnum='+list[i].band_num;
			});
			div44.addEventListener("click",function(e){
				location.href='${cp}/rladudsh.do?band_numnum='+list[i].band_num;
			});
			bandList1.appendChild(div33);
			bandList1.appendChild(div44);
			
			//console.log(list[i].band_name);
			//console.log(list[i].band_intoroductio);	
		}
	}	

</script>