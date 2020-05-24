<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModal.jsp</title>
<link rel="stylesheet" href="${cp }/band_board/board2.css">
<style type="text/css">
.boardContent {
	display: table;
	position: relative;
	table-layout: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	width: 600px;
	height: 100%;
	padding-bottom: 60px;
}



.boardContent .preventSaveContent {
	position: absolute;
	left: 0;
	top: 0;
	right: 0;
	bottom: 61px;
	z-index: 1;
}

.boardContent .btnArea.leftArea {
	left: 0;
	text-align: left;
}

.boardContent .btnArea {
	display: block;
	position: absolute;
	top: 0;
	bottom: 61px;
	width: 124%;
	z-index: 2;
}

.photoContent .btnArea .btnPrev {
	left: 0;
}

.btnArea.rightArea {
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

.boardContent .btnArea .btnNext {
	right: 0;
}

.gSrOnly {
	overflow: hidden !important;
	position: absolute !important;
	height: 1px !important;
	width: 1px !important;
	clip: rect(1px, 1px, 1px, 1px) !important;
}

.modal-content{
	 background-color: transparent !important;
     box-shadow: none;
     border: none;
     height: auto;
}


</style>
<script>
	var comments_page = 1;
	
	// 앨범 페이지에서 이미지 클릭시 이미지 번호를 받아와 이미지 세팅 Ajax
	$('#boardModal').on('show.bs.modal', function() {
		alert("Asd");
		var board_num = $('#board_num').val();
		$.ajax({
			data : {
				board_num : board_num,
				band_num : '${b_n}',
				comments_page : comments_page
			},
			type : "POST",
			dataType : 'JSON',
			url : '${cp}/boardModal.do',
			success : Modallist_view,
			error : function() {
				alert("server error");
			}
		});

	})
	
	
	// Ajax 호출후 성공하 이미지 세팅 함수..
	function Modallist_view(data) {
		$('#boardList2').empty();
		
		let board = document.getElementById("boardList2");
		
		let board_view = document.createElement("div");
		board_view.setAttribute("id", "board_view2");
		board.appendChild(board_view);
		
		let writeContent = document.createElement("div");
		writeContent.setAttribute("id", "writeContent2");
		board_view.appendChild(writeContent);
		
		//게시글 정보 글쓴이 프로필 이름 수정 삭제 업데이날짜.
		let board_info = document.createElement("div");
		board_info.setAttribute("id","board_info2");
		board_info.setAttribute('style', 'border-bottom:1px solid gray');
		
		let row = document.createElement("div");
		row.setAttribute("class","row")
		board_info.appendChild(row);
		
		// 게시글 작성자 프로필 이미지
		let profile = document.createElement("div");
		profile.setAttribute("class","col-sm-2");
		let img = document.createElement("img");
		img.setAttribute("class","img-responsive img-circle text-center");
		img.setAttribute("src",'${cp }/upload/img_profile.jpg');
		profile.appendChild(img);
		row.appendChild(profile);
		
		let user_info = document.createElement("div");
		user_info.setAttribute("class","col-sm-8")
		
		let user_name = document.createElement("label");
		let name = document.createTextNode(data.band_nickname); 
		user_name.appendChild(name);
		user_info.appendChild(user_name);
		
		let bb = document.createElement("br");
		user_info.appendChild(bb);
		
		let user_date = document.createElement("label");
		let date = document.createTextNode(data.board_redate);
		user_date.setAttribute("style","color:#999; font-size:12px");
		user_date.appendChild(date);		
		user_info.appendChild(user_date);
		
		row.appendChild(user_info);
		
		let btn_col = document.createElement("div");
		btn_col.setAttribute("class","col-sm-2");
		
		if(data.userband_num == '${userband_num}' || '${band_approved}' == 1){
			// 수정 삭제...
			let btn = document.createElement("button");
			btn.setAttribute("type","button");
			btn.setAttribute("style","border: none; background : none;");
			btn.setAttribute("class","btn-defaul btn-lg dropdown-toggle");
			btn.setAttribute("data-toggle","dropdown");
			
			
			let img1 = document.createElement("i");
			img1.setAttribute("class","glyphicon glyphicon-option-vertical");
			
			btn.appendChild(img1);
			btn_col.appendChild(btn);
			
			let btn_col1 = document.createElement("ul");
			btn_col1.setAttribute("class","dropdown-menu");
			
			let li1 = document.createElement("li");
			let a1 = document.createElement("a");
			a1.setAttribute("class","dropdown-item");
			a1.innerText="수정";
			li1.appendChild(a1);
		
			
			
			let li2 = document.createElement("li");
			let a2 = document.createElement("a");
			a2.setAttribute("class","dropdown-item");
			a2.innerText="삭제";
			li2.appendChild(a2);
			
			
			btn_col1.appendChild(li1);
			btn_col1.appendChild(li2);

			btn_col.appendChild(btn_col1);
		}
		
		// 수정 삭제 row에 추가..
		row.appendChild(btn_col);
		
		
		// 게시글 글자만 출력
		let content_view = document.createElement("div");
		content_view.setAttribute("id","content_view2");
		
		content_view.innerHTML = data.board_content
		
		// 글정보 및 글 content 붙이
		writeContent.appendChild(board_info);
		writeContent.appendChild(content_view);
		
		//댓글 버튼
		
		let comments_div = document.createElement("div");
		comments_div.setAttribute("id","comments_view2");
		
		
		
		let comments_row = document.createElement("div");
		comments_row.setAttribute("class", "row");
		comments_row.setAttribute("style", "padding:22px");
		
		//댓글 수 지
		let comments_cnt = document.createElement("div");
		comments_cnt.setAttribute("class","col-sm-2 text-center");
		console.log(data.comments_cnt);
		comments_cnt.innerText = "댓글 : " + data.comments_cnt;
		comments_cnt.setAttribute('style', 'font-weight:bold; padding-left:14px');
		
		//댓글 쓰기 버
		let comments_icon = document.createElement("div");
		comments_icon.setAttribute("class", "col-sm-12 text-center");
		comments_icon.setAttribute('style', 'border-top:1px solid gray; border-bottom:1px solid gray');
		let c_icon = document.createElement("i");
		c_icon.setAttribute("class","glyphicon glyphicon-comment");
		
		let c_label = document.createElement("label");
		c_label.innerHTML = "&nbsp;&nbsp;댓글쓰기";
		
		comments_icon.appendChild(comments_cnt);
		comments_icon.appendChild(c_icon);
		comments_icon.appendChild(c_label);
		comments_row.appendChild(comments_icon);
		comments_div.appendChild(comments_row);
		
		writeContent.appendChild(comments_div);
		
		// 댓글 list
		let comments_list = document.createElement("div");
		comments_list.setAttribute("class", "comments_List2");
		
		let comments = data.comments;
		
		if(comments !=null){
			for(let j = 0; j < Object.keys(data.comments).length;j++){
				let comment_div = document.createElement("div");
		 		comment_div.setAttribute("class", "row");
		 		
		 		let comment_user_img = document.createElement("div");
		 		comment_user_img.setAttribute("class", "col-sm-2");
		 		
		 		let img = document.createElement("img");
		 		img.setAttribute("class","img-responsive img-circle text-center");
				img.setAttribute("src",'${cp}/upload/img_profile.jpg');
				
				
		 		comment_user_img.appendChild(img);
		 		
		 		comment_div.appendChild(comment_user_img);
		 		
		 		let info = document.createElement("div");
		 		info.setAttribute("class", "col-sm-8");
		 		
		 		
		 		let user_name = document.createElement("label");
				let name = document.createTextNode(comments[j].band_nickname); 
				user_name.appendChild(name);
				info.appendChild(user_name);
				
				let bb = document.createElement("br");
				info.appendChild(bb);
				
				let user_comments = document.createElement("label");
				user_comments.innerText = comments[j].comments_content;
				info.appendChild(user_comments)
				
				let cc = document.createElement("br");
				info.appendChild(cc);
				
				let user_date = document.createElement("label");
				let date = document.createTextNode(comments[j].comments_date); 
				user_date.setAttribute("style","color:#999; font-size:11px");
				user_date.appendChild(date);		
				info.appendChild(user_date);
				info.setAttribute("style", "border-bottom:1px solid #999");
				comment_div.appendChild(info);
				comments_list.appendChild(comment_div);
				
				
				
			}
		}
		
		writeContent.appendChild(comments_list);
		
		// 댓글 입력
		let comment = document.createElement("div");
		comment.setAttribute("class", "commentInput");
		
		let comment_input = document.createElement("div");
		comment_input.setAttribute("class", "row");
		
		let comment_tmp = document.createElement("div");
		comment_tmp.setAttribute("class","col-sm-1");
		
		let comment_col = document.createElement("div");
		comment_col.setAttribute("class","col-sm-8");
		comment_col.setAttribute("style", " z-index: 999;");
		let comment_textarea = document.createElement("textarea");
		comment_textarea.setAttribute("class","comment_textarea");
		comment_textarea.setAttribute("cols","20");
		comment_textarea.setAttribute("rows","1");
		comment_textarea.setAttribute("placeholder","  댓글을 남겨주세요.");
		comment_textarea.setAttribute("style","display: inline-block; overflow: hidden; height: 32px; width:100%;z-index:999;");

		
		
		comment_col.appendChild(comment_textarea)
		
		let comment_col2 = document.createElement("div");
		comment_col2.setAttribute("class","col-sm-2");
		comment_col2.setAttribute("style", " z-index: 999;");
		let comment_send = document.createElement("button");
		comment_send.setAttribute("class", "btn");
		comment_send.setAttribute("style", "background :#b9b9b9; color:white;   outline: none;  border-radius: 13px; z-index:999;");
		comment_send.setAttribute("disabled", "false");
		comment_send.innerText = "보내기";
		
		$(comment_textarea).on('keyup',function(){		
			if(comment_textarea.value == "" || comment_textarea.value == null){
				$(comment_send).attr('disabled',true);
			}else{
				$(comment_send).attr('disabled',false);
			}
		})
		
		
		var cnt = data.comments_cnt;
		var maxpage = data.maxpage;
		let board_num= data.board_num;
		 function commentList2(data) {
		    	$(comments_list).empty();
		    	
		    	comments_cnt.innerText = "댓글 : " + cnt;
		    	
		    	let page_div = document.createElement("div");
		    	page_div.setAttribute("style", "padding:0 22px 0 22px;");
		    	
		    	let page = document.createElement("div");
		    	page.setAttribute("class", "row");
		    	page.setAttribute("style", "border-bottom: 1px solid #999; padding: 0 22px 0 22px;");
		    	
		    	
		    	let comments_prev = document.createElement("div");
		 		comments_prev.setAttribute("class", "col-sm-6 text-left");
		 		comments_prev.setAttribute("id","comments_prev");
		 		
		    	if(comments_page<maxpage){
		    		console.log("asd");
			 		comments_prev.innerHTML = "이전으로";
			 		comments_prev.setAttribute("style", "font-weight:bold;font-size:18px")
			 		
			 		$(comments_prev).on('click',function(){
			 			comments_page+=1;
			 			$.ajax({
			 				type: "post",
							data: { 
								board_num: board_num,
								comments_page: comments_page,
							},
							dataType:'JSON',
						    url: '${cp}/commentsList.do',
						    success: commentList2
			 			})
			 		})
			 		
			 	}
		    	page.appendChild(comments_prev);
		    	
		    	let comments_next = document.createElement("div");
	 			comments_next.setAttribute("class", "col-sm-6 text-right");
	 			comments_next.setAttribute("id","comments_next");
		    	if(comments_page>1){
		 			comments_next.innerHTML = "다음으로";
		 			comments_next.setAttribute("style", "font-weight:bold; font-size:18px");
		 			
		 			$(comments_next).on('click',function(){
		 				comments_page-=1;
			 			$.ajax({
			 				type: "post",
							data: { 
								board_num: board_num,
								comments_page: comments_page,
							},
							dataType:'JSON',
						    url: '${cp}/commentsList.do',
						    success: commentList2
			 			})
			 		})
		  		}
		    	page.appendChild(comments_next);
		    	
		    	page_div.appendChild(page);
		    	comments_list.appendChild(page_div);
		    	
		  	  	for(let y = 0; y<data.json.length;y++){
			 		let comment_div = document.createElement("div");
			 		comment_div.setAttribute("class", "row");
			 		
			 		let comment_user_img = document.createElement("div");
			 		comment_user_img.setAttribute("class", "col-sm-2");
			 		
			 		let img = document.createElement("img");
			 		img.setAttribute("class","img-responsive img-circle text-center");
					img.setAttribute("src",'${cp}/upload/img_profile.jpg');
					
					
			 		comment_user_img.appendChild(img);
			 		
			 		comment_div.appendChild(comment_user_img);
			 		
			 		let info = document.createElement("div");
			 		info.setAttribute("class", "col-sm-8");
			 		
			 		
			 		let user_name = document.createElement("label");
					let name = document.createTextNode(data.json[y].band_nickname); 
					user_name.appendChild(name);
					info.appendChild(user_name);
					
					let bb = document.createElement("br");
					info.appendChild(bb);
					
					let user_comments = document.createElement("label");
					user_comments.innerText = data.json[y].comments_content;
					info.appendChild(user_comments)
					
					let cc = document.createElement("br");
					info.appendChild(cc);
					
					let user_date = document.createElement("label");
					let date = document.createTextNode(data.json[y].comments_date);
					user_date.setAttribute("style","color:#999; font-size:11px");
					user_date.appendChild(date);		
					info.appendChild(user_date);
					info.setAttribute("style", "border-bottom:1px solid #999");
					comment_div.appendChild(info);
					
					if(data.json[y].userband_num == '${userband_num}'){
						let updel = document.createElement("div");
						updel.setAttribute("class", "col-sm-2");
						
						let bt = document.createElement("button");
						bt.setAttribute("type","button");
						bt.setAttribute("style","border: none; background : none;");
						bt.setAttribute("class","btn-defaul btn-lg dropdown-toggle");
						bt.setAttribute("data-toggle","dropdown");
						
						
						let im1 = document.createElement("i");
						im1.setAttribute("class","glyphicon glyphicon-option-vertical");
						
						bt.appendChild(im1);
						updel.appendChild(bt);
						
						let bt_col1 = document.createElement("ul");
						bt_col1.setAttribute("class","dropdown-menu");
					
						
						let l2 = document.createElement("li");
						let a22 = document.createElement("a");
						a22.setAttribute("class","dropdown-item");
						a22.innerText="삭제";
						l2.appendChild(a22);
						
						$(l2).on('click',function(){
							$.ajax({
								type: "post",
								data: { 
									board_num: board_num,
									comments_num: data.json[y].comments_num
								},
								dataType:'JSON',
							    url: '${cp}/commentdelete.do',
							    success: function(data) {
							    	if(data.result=='success'){
							    		console.log("reset")
								    	$.ajax({
							 				type: "post",
											data: { 
												board_num: board_num,
												comments_page: comments_page,
											},
											dataType:'JSON',
										    url: '${cp}/commentsList.do',
										    success: commentList2
							 			})
							    	}
								}								
							})
						})
				
						bt_col1.appendChild(l2);

						updel.appendChild(bt_col1);
						comment_div.appendChild(updel);
					}
					comments_list.appendChild(comment_div);
					
					
		 		}
			}
		 $(comments_cnt).on('click',function(){
				$.ajax({
	 				type: "post",
					data: { 
						board_num: board_num,
						comments_page: comments_page,
					},
					dataType:'JSON',
				    url: '${cp}/commentsList.do',
				    success: commentList2
	 			})
		}) 
			
		$(comment_send).on('click',function(){
			comments_page = 1;
			var comments_text = comment_textarea.value;
			$.ajax({							
				type: "post",
				data: { 
					band_num :'${b_n}',
					userband_num :'${userband_num}',
					board_num: board_num,
					comments_text:comments_text		
				},
				dataType:'JSON',
			    url: '${cp}/commentsUpload.do',
			    success: function(data){
			    	
			 		if(data.result == "success"){
			 			comment_textarea.value="";
			 			$.ajax({
			 				type: "post",
							data: { 
								board_num: board_num,
								comments_page: comments_page,
							},
							dataType:'JSON',
						    url: '${cp}/commentsList.do',
						    success: commentList2
			 			})	
			 		}		
			 	}
			})
		})
		
		comment_col2.appendChild(comment_send)
		
		comment_input.appendChild(comment_tmp);
		comment_input.appendChild(comment_col);
		comment_input.appendChild(comment_col2);
		comment.appendChild(comment_input)
		writeContent.appendChild(comment_input);
		
	}
	
	
	// 이전버튼 클릭 이벤트 함수
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
	
	// 다음 버튼클릭 이벤트 함수
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

	
	<div class="boardContent">
			
		<div class="mediaWrap _mediaWrap modal-body" style="padding: 40px 100px;">
			
			<div id="boardList2"></div>

			<span class="btnArea leftArea _previousImageButton">
				<button type="button" class="btnPrev glyphicon glyphicon-menu-left"
					id="prevBtn"></button>
			</span> <span class="btnArea rightArea _nextImageButton">
				<button type="button" class="btnNext glyphicon glyphicon-menu-right"
					id="nextBtn"></button>
			</span>
		</div>

		<input type="hidden" value="" id="board_num"> <input
			type="hidden" value="" id="prevNum"> <input type="hidden"
			value="" id="nextNum">

	</div>

</body>
</html>