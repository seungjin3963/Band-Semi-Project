<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>albumMoal.jsp</title>
<style type="text/css">

.photoContent {
    display: table;
    position: relative;
    table-layout: fixed;
    text-align: center;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
    padding-bottom: 60px;
}

photoContent .mediaWrap {
    display: table-cell;
    width: 100%;
    height: 100%;
    vertical-align: middle;
}
img {
    border-style: none;
}

.photoContent .preventSaveContent {
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 61px;
    z-index: 1;
}
.photoContent .btnArea.leftArea {
    left: 0;
    text-align: left;
}
.photoContent .btnArea {
    display: block;
    position: absolute;
    top: 0;
    bottom: 61px;
    width: 50%;
    z-index: 2;
}
.photoContent .btnArea .btnPrev {
    left: 0;
}
.btnArea.rightArea {
    right: 0;
    text-align: right;
}
.btnArea .btnPrev {
    position: absolute;
    top: 50%;
    z-index: 2;
    width: 100px;
    height: 131px;
    margin-top: -65px;
    text-align: center;
    outline: 0;
    background-color: transparent;
    border: none;
}
.btnArea .btnNext {
    position: absolute;
    top: 50%;
    z-index: 2;
    width: 100px;
    height: 131px;
    margin-top: -65px;
    text-align: center;
    outline: 0;
    background-color: transparent;
    border: none;
}
.photoContent .btnArea .btnNext {
    right: 0;
}
.gSrOnly {
    overflow: hidden!important;
    position: absolute!important;
    height: 1px!important;
    width: 1px!important;
    clip: rect(1px,1px,1px,1px)!important;
}
.modal-content {
     background-color: transparent !important;
     box-shadow: none;
     border: none;
	}
</style>
<script>

	$('#albumModal').on('show.bs.modal', function() {
		var img_num = $('#img_num').val();
		$.ajax({
			data : {
				img_num : img_num,
				band_num : '${b_n}'
			},
			type : "POST",
			dataType : 'JSON',
			url : '${cp}/albumModal.do',
			success : getAlbum,
			error : function() {
				alert("server error");
			}
		});

	})
	
	function getAlbum(data) {
		
		let prevNum = data.prevNum;
		let nextNum = data.nextNum;
		console.log(prevNum);
		console.log(nextNum);
		
		$("#imgSrc").attr("src", data.img_url);

		$('#prevNum').val(prevNum);
		$('#nextNum').val(nextNum);
		if(nextNum == 0 ||nextNum == null ){
			
			$('#nextBtn').hide()
		}else{
			$('#nextBtn').show();
		}
		if(prevNum == 0 || prevNum == null){
			$('#prevBtn').hide()
		}else{
			$('#prevBtn').show()
		}
	}
	
	
	$('#prevBtn').on('click',function(){
		var img_num = $('#prevNum').val();
		$.ajax({
			data : {
				img_num : img_num,
				band_num : '${b_n}'
			},
			type : "POST",
			dataType : 'JSON',
			url : '${cp}/albumModal.do',
			success : getAlbum,
			error : function() {
				alert("server error");
			}
		});
	})
	
	$('#nextBtn').on('click',function(){
		var img_num = $('#nextNum').val();
		$.ajax({
			data : {
				img_num : img_num,
				band_num : '${b_n}'
			},
			type : "POST",
			dataType : 'JSON',
			url : '${cp}/albumModal.do',
			success : getAlbum,
			error : function() {
				alert("server error");
			}
		});
	})
	
</script>
</head>
<body>

	<div class="modal-content"></div>
	<button type="button" class="close glyphicon glyphicon-remove"
		data-dismiss="modal" aria-hidden="true" id="closeBtn1"></button>

	<div class="photoContent">

		<div class="mediaWrap _mediaWrap" style="padding: 40px 100px;">

			<img id="imgSrc"
				style="z-index: 1; width:100%; height: auto;">


			<span class="btnArea leftArea _previousImageButton" >
				<button type="button" class="btnPrev glyphicon glyphicon-menu-left" id="prevBtn">
				</button>
			</span> 
			<span class="btnArea rightArea _nextImageButton" >
				<button type="button" class="btnNext glyphicon glyphicon-menu-right" id="nextBtn" >
				</button>
			</span>



		</div>

		<input type="hidden" value="" id="img_num"> 
		<input type="hidden" value="" id="prevNum"> 
		<input type="hidden" value="" id="nextNum">

	</div>

</body>
</html>