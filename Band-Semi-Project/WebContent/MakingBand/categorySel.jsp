<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="category" style="text-align: center;">
	<form method="post" action="${cp }/bandcover.do" style="margin: auto;">
	<h2 style="display: inline-block;">카테고리 분류</h2>
		<input type="button" id="cabefor" onclick="cbeforpage()" value="<">
		<input type="hidden" value="1" id="beforassi">
		<input type="button" id="canext" onclick="cnextpage()" value=">">
		<input type="hidden" value="10" id="nextassi">
	<div id="makediv" style="width: 1780px; text-align: center;">
		<c:forEach var="category" items="${requestScope.category}">
			<div style="display: inline-block; width: 144px;">
				<img src="${category.categoryimg }" style="border-radius: 70%; overflow: hidden; width: 135px; margin: 20px;" class="class_url" onclick="detailcategory(this.src)">
				<strong class="catename">${category.category_btitle }</strong>
			</div>
		</c:forEach>
		<input type="hidden" value="" id="scategoryTransfer" name="scategory">
	</div>
	<div id="detail">
	</div>
		<input type="submit" value="다음" style="width: 150px; height: 50px; font-size: 20px; background-color: gray; color: white;">
		<input type="reset" value="취소" style="width: 150px; height: 50px; font-size: 20px;">
	</form>
</div>
<script>
	var beforassi=document.getElementById("beforassi");
	var nextassi=document.getElementById("nextassi");
	var scategoryTrandfer=document.getElementById("scategoryTransfer");
	var xhr=null;
	var on=0;
	
	function cbeforpage(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=category_change;
		var num=parseInt(beforassi.value)-10;
		
		if(num<1){
			num=17;
		}else if(num == 7){
			num=11;
		}
		
		xhr.open('post','${cp }/category.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('category='+num);
		beforassi.value=num;
		nextassi.value=num+9;
	}
	
	function cnextpage() {
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=category_change;
		var num=parseInt(nextassi.value)+1;
		
		if(num>17 && num<22){
			num=17;
		}else if(num>26){
			num=1;
		}
		xhr.open('post','${cp }/category.do',true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send('category='+num);
		nextassi.value=num+9;
		beforassi.value=num;
	}

	function category_change() {
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseText;
			var json=JSON.parse(xml);
			
			var catename=document.getElementsByClassName("catename");
			var url=document.getElementsByClassName("class_url");
			
			for(var i=0;i<10;i++){
				url[i].src=json[i].curl;
				catename[i].innerHTML=json[i].title;
			}
		}
	}

	function detailcategory(num) {
		var arraynum=num.split('/');
		var bnum=arraynum[6].split('.');
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=stitle;
		xhr.open("get", '${cp }/scategory.do?bcategorynum='+bnum[0], true);
		xhr.send();
 	}
	
	function stitle() {
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseText;
			var json=JSON.parse(xml);
			var detail=document.getElementById("detail");
			var divclass=document.getElementsByClassName("divclass");
			var categorylist=new Array();
			
			
			for(var i=0;i<json.length;i++){
				if(on>0){
					detail.removeChild(detail.firstChild);
				}

				var div=document.createElement("div");
				div.style.width="100px";
				div.style.height="50px";
				div.style.display="inline-block";
				div.style.border="1px solid black";
				div.style.margin="20px";
				div.style.fontSize="20px";
				div.className="divclass";
				
				div.innerHTML=json[i].category_stitle;
				
					
				categorylist[i]=json[i].scategorynum;

				div.addEventListener("click", function() {
					
					for (var i = 0; i < divclass.length; i++) {
						divclass[i].style.backgroundColor="white";
					}
					
					this.style.backgroundColor="gray";
				
					for (var i = 0; i < divclass.length; i++) {
						if(divclass[i] == this){
							scategoryTrandfer.value=categorylist[i];
						}
					}						
				
				});
				
				if(i == json.length-2){
					on=1;
				}
				
				detail.appendChild(div);
			}
		}
	}
</script>