<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String cp = request.getContextPath(); %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="<%=cp%>/Resources/css/bootstrap.css" rel="stylesheet">
<script src="<%=cp%>/Resources/js/bootstrap.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Band_album</title>
<style type="text/css">

	#main{
			height:auto;
			width:100%;
			padding-top: 40px;
		    padding-bottom: 20px;
		    display: block;
		    background-color: #EEF0F3;
	}
	#header #album_view{
	    padding-left: 20px;
		font-size: 18px;
		color : #222;
		font-weight: 600;
	}
	h2, h4{
		margin: 0;
		font-size: 14px;
		font-weight: 400;
		color:#222;
	}
	a{
		color :#222;
		text-decoration: none;
	}
	#albumImg{
		width:100%;
		margin-block-start:1em;
		margin-block-end:1em;
		margin-inline-start:0px;
		margin-inline-end:0px;
		padding-inline-start:30px
	}
	#albumImg li{
		position: relative;
		display: inline-table;		
	}
	#album_headerWrap #album_view{
		margin-top: 12px;
    	position: relative;
    } 
    #album_headerWrap #album_view{
    	padding-left: 20px;
    	position: relative;
    	display: flex;
   		height: 61px;
   		-webkit-box-align: center;
    }
    img{
    	margin:10px;
    	width: 164px;
    	height: 164px;
    }

</style>
<script type="text/javascript">
var imgPage = 0;
var totChk = true;
$(document).ready(function () 
{
	changeImg();
	setImg_view();
	
	$('#totImg').on('click',function(){
		if(totChk){
			imgPage +=1;
			$.ajax({
				 data:{  
					 band_num : '${b_n}',
					 imgPage: imgPage,
				  },
		         type: "POST",
		         dataType:'JSON',
		         url: '${cp}/board/imgview.do',
		         success: moreImg,
			})
		}
	})
});

function setImg_view() {
	$.ajax({
		 data:{  
			 band_num : '${b_n}',
			 imgPage: 0,
		  },
        type: "POST",
        dataType:'JSON',
        url: '${cp}/board/imgview.do',
        success: function(data){
       	 
       		 deleteImg();
       		 imgPage = 0;
	        	 var albumImg = document.getElementById('albumImg');
	        		for (let i = 0; i < data.length; i++) {
	        			let li = document.createElement("li");
	        			let img = document.createElement("img");
	        			img.setAttribute("src", data[i].img_url);
	        			$(img).on('click',function(){
	        				$('#img_num').val(data[i].img_num);	
	        				$('#albumModal').modal({
	        					backdrop : 'static',
	        	             	remote : '${cp }/band_album/albumModal.jsp'
	        	     		});
	        			})
	        			li.appendChild(img);
	        			albumImg.appendChild(li);
	        		}
	        		changeImg();
	        		var morehide = document.getElementById('morehide');
	        		$('#morehide').empty();
					if('${imgCnt}' > 6){
		        		let more = document.createElement("a");
		        		more.setAttribute("id", "moreImg");
		        		more.innerText = "더보기+";
	    			    morehide.appendChild(more);
	    			    setMoreImg();
					}
					totChk=true;
        },  
	})
}

function changeImg() {
	$('img').hover(function(){
		$(this).css('opacity','0.7');
	}, function() {
		$(this).css('opacity','1');
	});	
}

function setMoreImg(){
	$('#moreImg').on('click',function(){
		console.log("1234");
		imgPage +=1;
		$.ajax({
			 data:{  
				 band_num : '${b_n}',
				 imgPage: imgPage,
			  },
	         type: "POST",
	         dataType:'JSON',
	         url: '${cp}/board/imgview.do',
	         success: moreImg,
	         error: function () {
	             alert("server error");
	         }
			
		})
	})
}

function moreImg(data){	
	if(imgPage==1){
		deleteImg();
	}
	var albumImg = document.getElementById('albumImg');
	for (let i = 0; i < data.length; i++) {
		let li = document.createElement("li");
		let img = document.createElement("img");
		img.setAttribute("src", data[i].img_url);
		$(img).on('click',function(){
			$('#img_num').val(data[i].img_num);	
			$('#albumModal').modal({
				backdrop : 'static',
             	remote : '${cp}/band_album/albumModal.jsp'
     		});
		});
		li.appendChild(img);
		albumImg.appendChild(li);
		
		changeImg();
	}
	var morehide = document.getElementById('morehide');
	$('#morehide').empty();
	
	if(imgPage >= '${maxPage}'){
		let hide = document.createElement("a");
		hide.setAttribute("id", "hideImg");
		hide.innerText = "접기↑";
		morehide.appendChild(hide);
		$(hide).on('click',function(){
			setImg_view();
		})
	}else{
		let more = document.createElement("a");
		more.setAttribute("id", "moreImg");
		more.innerText = "더보기+";
	    morehide.appendChild(more);
	    setMoreImg();
	}
}

function deleteImg(){
	$('#albumImg').empty();	
}

</script>

</head>
<body>

<div class="container" id="main">
	<div id="album_headerWrap">
		<div id="header">
			<h1>사진첩</h1>
		</div>
	</div>
	<div id="album_view">
		<div id="view_header" style="border-bottom : 1px solid gray">
			<h2>
				<a id="totImg">
					<strong>전체사진</strong>
					<em>
						${imgCnt}
					</em>
				</a>
			</h2>	
		</div>
		<ul id="albumImg">
			<%-- <c:forEach var="vo" items="${list}" varStatus="status">
				<li>
					<img src='${vo.img_url}'>
				</li>
			</c:forEach> --%>
		</ul>
		<c:if test="${imgCnt>6}">			
				<div id="more_view">
					<div class="text-center" id="morehide">
						<!-- <a id="moreImg">
							더보기+
						</a> -->
					</div>
				</div>
		</c:if>
		
	</div>
</div>

<!-- 앨범 모달 -->
<div id="albumModal" class="modal fade">
	<div class="modal-dialog">
	<div class="modal-content">
	</div>
	</div>
</div>
</body>
<script type="text/javascript">
$('#albumModal').modal({
	backdrop : 'static',
 	remote : '${cp }/band_album/albumModal.jsp'
});
$('#albumModal').modal('hide');
</script>
</html>