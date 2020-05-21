<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
	$(document).ready(function() {
		  $('#summernote').summernote({
	 	    	placeholder: 'content',
		        minHeight: 370,
		        maxHeight: 370,
		        focus: true, 
		        lang : 'ko-KR',
		        dialogsInBody: true,		        
		        callbacks:{
			        	onImageUpload: function(files, editor, welEditable) {
							for(var i = files.length-1; i>=0;i--){
								sendFile(files[i],this);
							}
						},
						onMediaDelete : function(target) {
				              deleteFile(target[0].src);
				        }
		        }
		  });
		  $('#myButtons1').attr("disabled", true);
		  
		  $('#summernote').on('summernote.keyup', function(we, e) {
			  var code = $('#summernote').summernote('code');
			  if(code == "<p><br></p>" || code ==""){
				  $('#myButtons1').attr("disabled", true);
			  }else{
				  $('#myButtons1').attr("disabled", false);
			  }
		  });
		
		  
		  $("#myButtons1").click(function (e){
			 var code = $('#summernote').summernote('code');
			 var userband_num = $('#userband_num').val();
			 var band_num = $('#band_num').val();
			 var boardState = 0;
			 var check = $('#noticeChk').is(":checked");
			    if(check){
			    	boardState = 3;
			    } else {
			    	boardState = 1;
			    }
			 
			var board_num = $('#board_num').val();
			if(board_num >0){
				$('#myModalLabel').text('글쓰기');	
				
				 $.ajax({
					  data:{  code:code,
							  userband_num: userband_num,
							  band_num: band_num,
							  board_num: board_num,
							  boardState:boardState
						  },
	                  type: "POST",
	                  url: '${cp}/board/boardupdate.do',
	                  success: getBoardList,
	                  error: function () {
	                      alert("server error");
	                  }
	              });
			}else{
				 $.ajax({
					  data:{  code:code,
							  userband_num:userband_num,
							  band_num:band_num,
							  boardState:boardState
						  },
	                  type: "POST",
	                  url: '${cp}/board/BoardUpload.do',
	                  cache: false,
	                  success: getBoardList,
	                  error: function () {
	                      alert("server error");
	                  }
	              });
			}   		 
          });
		});
	
	
	function deleteFile(src) {
		var userband_num = '${userband_num}';
	    $.ajax({
	        data: {src : src,userband_num:userband_num},
	        type: "POST",
	        url: '<%=cp%>/summernoteDelete.do',
	        cache: false,
	        success: function(resp) {
	            console.log(resp);
	        }
	    });
	}
	
	function sendFile(file,el){
		var form_data = new FormData();
		form_data.append('file',file);
		var userband_num = '${userband_num}';
		form_data.append('userband_num',userband_num);
		$.ajax({
			data: form_data,
			type:"POST",
			url: '${cp}/summernoteUpload.do',
			dataType: "text",
			cache: false,
			contentType: false,
			enctype: 'multipart/form-data',
			processData:false,
			success: function(data) {
				$(el).summernote('editor.insertImage', data);
				
			}
		})
	}
	
	$('#closeBtn').on('click',function(){
		 var board_num = $('#board_num').val();
		 if(board_num >0){
			 $('#myModalLabel').text('글쓰기'); 
		 }
		var userband_num = '${userband_num}';
		var url = $('#summernote').summernote('code');
		$.ajax({
		    type: "post",
		    url: '${cp}/resetDelete.do',
		    data: {text: url,userband_num:userband_num},
		    success: function() {
		    }
		});		
	})
	
	$('#closeBtn1').on('click',function(){
		 var board_num = $('#board_num').val();
		 if(board_num >0){
			 console.log(board_num);
			 $('#myModalLabel').text('글쓰기'); 
		 }
		var userband_num = '${userband_num}';
		var url = $('#summernote').summernote('code');
		$.ajax({
		    type: "post",
		    url: '${cp}/resetDelete.do',
		    data: {text: url,userband_num:userband_num},
		    success: function() {
		    }
		});		
	})

</script>
<title>글쓰기</title>
</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true" id="closeBtn1">×</button>
		<h2 class="modal-title" id="myModalLabel" style="text-align: center;">글쓰기</h2>
	</div>
	<div class="modal-body">
		<div class="modal-body" style="width: 100%; margin: auto;">
			<form id="summernote"></form>
		</div>
	</div>
	<div class="modal-footer">
		<form  method="post" id="myForm">
        	<textarea name="summerNoteText" style="display:none;"></textarea>
        	<input type="hidden" id="userband_num" value="0">
        	<input type="hidden" id="band_num" value="0">
        	<input type="hidden" id="board_num" value="0">
        	<input type="checkbox" value="1" id="noticeChk"/>공지사항
        	<button type="button" class="btn btn-default" data-dismiss="modal" id="closeBtn">닫기</button>
			<button type="submit" class="btn btn-primary" id="myButtons1">저장</button>
    	</form>
	</div>
</body>
</html>