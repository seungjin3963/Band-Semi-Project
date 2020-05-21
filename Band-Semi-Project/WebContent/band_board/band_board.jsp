<%@page import="jhta.band.vo.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${cp }/band_board/board.css">
<title>글쓰기</title>

<script>
	$(function(){
	    $("#contentEditor").on('click', function(){
	        $('#writeModal').modal({
	        				backdrop : 'static',
	                     	remote : '${cp }/band_board/board_writer.jsp'
	             		});
	        $('#summernote').summernote('reset');
	        console.log('${userband_num}');
	        console.log('${b_n}');
	        $('#userband_num').val('${userband_num}');
	        $('#band_num').val('${b_n}');
	    })
	})
	
	
	function getBoardList(data){
		if(data !=null){
			console.log(data.result);
			console.log('${b_n}')
		}
		
		$.ajax({
			type: "post",
			data: { 
				band_num :'${b_n}'			
			},
			dataType:'JSON',
		    url: '${cp }/contentUpload.do',
		    success: list_view
		})
		
	}
	
	
 	function list_view(data) {
 		console.log('${userband_num}');
 		console.log('${b_n}');
 		
 		deleteList();
		let board = document.getElementById("boardList");
		
		for(let i = 0; i<data.length; i++){
			
			let board_view = document.createElement("div");
			board_view.setAttribute("id", "board_view");
			board.appendChild(board_view);
			let writeContent = document.createElement("div");
			writeContent.setAttribute("id", "writeContent");
			board_view.appendChild(writeContent);
			
			let board_info = document.createElement("div");
			board_info.setAttribute("id","board_info");
			board_info.setAttribute('style', 'border-bottom:1px solid gray');
			
			
			let row = document.createElement("div");
			row.setAttribute("class","row")
			board_info.appendChild(row);
			
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
			let name = document.createTextNode(data[i].band_nickname); 
			user_name.appendChild(name);
			user_info.appendChild(user_name);
			
			let bb = document.createElement("br");
			user_info.appendChild(bb);
			
			let user_date = document.createElement("label");
			let date = document.createTextNode(data[i].board_redate); 
			user_date.appendChild(date);		
			user_info.appendChild(user_date);
			
			row.appendChild(user_info);
			
			let btn_col = document.createElement("div");
			btn_col.setAttribute("class","col-sm-2");
			
			if(data[i].userband_num == '${userband_num}'){
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
				
				$(li1).on('click',function(){
					$('#writeModal').modal({
	     				backdrop : 'static',
	                  	remote : '${cp}/band_board/board_writer.jsp'
	          		});
					$('#summernote').summernote('code',data[i].board_content);
					
					$('#myModalLabel').text('글수정');
					$('#board_num').val(data[i].board_num);
				})
				
				
				
				let li2 = document.createElement("li");
				let a2 = document.createElement("a");
				a2.setAttribute("class","dropdown-item");
				a2.innerText="삭제";
				li2.appendChild(a2);
				
				$(li2).on('click',function(){
					 $.ajax({
						  data:{  
								  board_num: data[i].board_num,
							  },
		                  type: "POST",
		                  dataType:'JSON',
		                  url: '${cp}/board/boarddelete.do',
		                  success: getBoardList,
		                  error: function () {
		                      alert("server error");
		                  }
		              });
				})
				
				btn_col1.appendChild(li1);
				btn_col1.appendChild(li2);
	
				btn_col.appendChild(btn_col1);
			}
			row.appendChild(btn_col);

			// 게시글 글자만 출력
			let content_view = document.createElement("div");
			content_view.setAttribute("id","content_view")
	
			let t = data[i].board_content.replace(/<p[^>]*>/g,"").replace(/<\/p>/g,"\n");
			let s = t.replace(/<br[^>]*>/g,"");
			
			let text = s.replace(/(<([^>]+)>)/g,"");
			let con = text.replace(/(?:\r\n|\r|\n)/g, '<br>');
			
			let result = con.split("<br>");
			
			for(let z = 0; z <result.length; z++){
				if(result[z] !== ""){
					content_view.innerHTML += result[z] + "<br>";
				}
				
				if(z>=4){
					let more = document.createElement("button");
					more.setAttribute("class","btn btn-light");
					more.setAttribute("style","outline: none; border: none; padding:0px; background:none;");
					more.innerHTML="<span style='color:#999;'>...더보기</span>";
					content_view.appendChild(more);
					break;
				}
			}
			writeContent.appendChild(board_info);
			writeContent.appendChild(content_view);
			
			
			//이미지 출력
			
			let img_list = document.createElement("div");
				img_list.setAttribute("id","img_view");
			let img_row = document.createElement("div");
				img_row.setAttribute("class","row");
			
			let jarr = data[i].img_url;
			let maxImg = true;
			
			if(jarr !=null){
				for(let j = 0; j < Object.keys(jarr).length;j++){
	
					let img_col1 = document.createElement("div");
					img_col1.setAttribute("class","col-sm-6");
					let img_url1 = document.createElement("img");
					img_url1.setAttribute("src",jarr[j].img_url);
					img_url1.setAttribute("class","img-thumbnail center-block");
					img_url1.setAttribute("id","img_preview");
					if((j+1)%2 == 0 ){
						if(maxImg == true){
							img_col1.appendChild(img_url1);
							img_row.appendChild(img_col1);
							img_list.appendChild(img_row);
							img_row = document.createElement("div");
							img_row.setAttribute("class","row");
							maxImg = false;
						}else{							
							if(Object.keys(jarr).length > 4){	
								img_url1.setAttribute("style","display: inline-block;position: absolute; margin-left:13px; opacity: 0.8;");
								img_col1.setAttribute("sytle","position: relative;");
								img_col1.innerHTML +="<div style='position: absolute; display: inline-block; width:250px; height:250px; text-align:center; line-height:220px; font-weight: bold; font-size:20px; color:black'>더보기+</div>";
							}
							img_col1.appendChild(img_url1);
							img_row.appendChild(img_col1);
							img_list.appendChild(img_row);
							break;
						}
					}else{
						if(Object.keys(jarr).length == 1 || (Object.keys(jarr).length == 3 && j ==2))
						{
							img_col1.setAttribute("class","col-sm-12");
						}
						img_col1.appendChild(img_url1);
						img_row.appendChild(img_col1);
					}
				}
				img_list.appendChild(img_row);
				writeContent.appendChild(img_list);
			}
			
			//댓글 버튼
			
			let comments_div = document.createElement("div");
			comments_div.setAttribute("id","comments_view");
			
			
			
			let comments_row = document.createElement("div");
			comments_row.setAttribute("class", "row");
			comments_row.setAttribute("style", "padding:22px");
			
			let comments_cnt = document.createElement("div");
			comments_cnt.setAttribute("class","col-sm-2 text-center");
			console.log(data[i].comments_cnt);
			comments_cnt.innerText = "댓글 : " + data[i].comments_cnt;
			comments_cnt.setAttribute('style', 'font-weight:bold; padding-left:14px');
			
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
			
			writeContent.appendChild(comments_div)
			
			// 댓글 list
			let comments_list = document.createElement("div");
			comments_list.setAttribute("class", "comments_List")
			
			let comments = data[i].comments;
			
			if(comments !=null){
				for(let j = 0; j < Object.keys(comments).length;j++){
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
					user_date.appendChild(date);		
					info.appendChild(user_date);
					info.setAttribute("style", "border-bottom:1px solid #999");
					comment_div.appendChild(info);
					comments_list.appendChild(comment_div);
				}
			}
		
			writeContent.appendChild(comments_list);
			
			let comments_page = 1;
			
			
			let click = true;
			$(comments_div).on('click',function(){
			
				if(click == true){
					console.log('click');
					let comments = document.createElement("div");
					comments.setAttribute("class", "commentInput");
					
					let comment_input = document.createElement("div");
					comment_input.setAttribute("class", "row");
					
					let comment_tmp = document.createElement("div");
					comment_tmp.setAttribute("class","col-sm-1");
					
					let comment_col = document.createElement("div");
					comment_col.setAttribute("class","col-sm-8");
					
					let comment_textarea = document.createElement("textarea");
					comment_textarea.setAttribute("class","comment_textarea");
					comment_textarea.setAttribute("cols","20");
					comment_textarea.setAttribute("rows","1");
					comment_textarea.setAttribute("placeholder","  댓글을 남겨주세요.");
					comment_textarea.setAttribute("style","display: inline-block; overflow: hidden; height: 32px; width:100%");

					
					
					comment_col.appendChild(comment_textarea)
					
					let comment_col2 = document.createElement("div");
					comment_col2.setAttribute("class","col-sm-2");
					let comment_send = document.createElement("button");
					comment_send.setAttribute("class", "btn");
					comment_send.setAttribute("style", "background :#b9b9b9; color:white;   outline: none;  border-radius: 13px;");
					comment_send.setAttribute("disabled", "false");
					comment_send.innerText = "보내기";
					
					$(comment_textarea).on('keyup',function(){		
						if(comment_textarea.value == "" || comment_textarea.value == null){
							$(comment_send).attr('disabled',true);
						}else{
							$(comment_send).attr('disabled',false);
						}
					})
					
					
					let board_num = data[i].board_num;
					
					 function commentList(data) {
					    	deleteComment(comments_list);
					    	comments_cnt.innerText = "댓글 : " + data.comments_cnt;
					    	
					    	let page_div = document.createElement("div");
					    	page_div.setAttribute("style", "padding:0 22px 0 22px;");
					    	
					    	let page = document.createElement("div");
					    	page.setAttribute("class", "row");
					    	page.setAttribute("style", "border-bottom: 1px solid #999; padding: 0 22px 0 22px;");
					    	
					    	let max = data.maxpage;
					    	
					    	let comments_prev = document.createElement("div");
					 		comments_prev.setAttribute("class", "col-sm-6 text-left");
					 		comments_prev.setAttribute("id","comments_prev");
					 		
					    	if(comments_page<max){
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
									    success: commentList
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
									    success: commentList
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
													    success: commentList
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
							    success: commentList
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
								board_num: data[i].board_num,
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
									    url: '<%=cp%>/commentsList.do',
									    success: commentList
						 			})	
						 		}		
						 	}
						})
					})
					comment_col2.appendChild(comment_send)
					
					comment_input.appendChild(comment_tmp);
					comment_input.appendChild(comment_col);
					comment_input.appendChild(comment_col2);
					comments.appendChild(comment_input)
					writeContent.appendChild(comment_input);
					click =false;
				}
			})	
		}
    }	 
 	function deleteComment(event) {
 		
 		while ( event.hasChildNodes() ) { 
 			event.removeChild( event.firstChild ); 
 		}
 	}
 	function deleteList() {
 		/* var board = document.getElementById("boardList"); 
 		
 		while ( board.hasChildNodes() ) { 
 			board.removeChild( board.firstChild ); 
 		} */
		$('#boardList').empty();
	}
 	
</script>
</head>
<body onload="getBoardList()"> 
	<section class="boardList">
		<!-- 게시글 검색 템플릿 -->
		<form class="form-horizontal" role="form">
			<div class="input-group" id="searchFrom">
				<input type="text" class="form-control" placeholder="글 내용, #태그" id="searchInput">
					<span class="input-group-btn" >
						<button type="submit" class="btn btn-default" style="height:34px" id="searchBtn">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
			</div>
		</form>
		
		<!-- 글쓰기 템플릿 -->
		<div class="form-horizontal">
			<div class="row" id="postWrite">
				<div class="col-sm-4 container" id="contentEditor">
					<span class="contentEx">새로운 소식을 남겨보세요.</span>
				</div>
			</div>
		</div>
		

		<!-- 게시글 출력 -->
		
		<div class="form-horizontal" id="boardList"></div>
		
	</section>
	
	<!-- writer 모달 content--> 
		<div id="writeModal" class="modal fade" >
			<div class="modal-dialog">
				<div class="modal-content">
				</div>
			</div>
		</div>
	
	
</body>
<script type="text/javascript">
$('#writeModal').modal({
	backdrop : 'static',
  	remote : '${cp}/band_board/board_writer.jsp'
	});
$('#writeModal').modal('hide');
</script>
</html>