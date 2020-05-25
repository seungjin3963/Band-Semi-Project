<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script type="text/javascript">
	$('#imgModal').on('show.bs.modal', function() {
		$('#carousel-example-generic').carousel();
		var board_num = $('#imgboard_num').val();
		console.log(board_num);
		$.ajax({
			data : {
				board_num : board_num
			},
			type : "POST",
			dataType : 'JSON',
			url : '${cp}/imgModal.do',
			success : getImgList,
			error : function() {
				alert("server error");
			}
		});

	})

	function getImgList(data) {
		$('#carousel_indicators').empty();
		$('#carousel_inner').empty();
		$('#carousel-example-generic').carousel();
		let body = $('#imgModal_main');
		let targer = $('#imgboard_url');
		console.log(targer.val());
		for (var i = 0; i < data.length; i++) {
			console.log(data[i].url);
			let li = document.createElement("li");
			li.setAttribute("data-target", "#carousel-example-generic");
			li.setAttribute("data-slide-to", i);
			$('#carousel_indicators').append(li);
			let div = document.createElement("div");
			if (targer.val() == data[i].url) {
				div.setAttribute("class", "item active");
			} else {
				div.setAttribute("class", "item");
			}
			let img = document.createElement("img");
			img.setAttribute("style", "width:100%");
			img.setAttribute("src", data[i].url);
			div.append(img);
			$('#carousel_inner').append(div);
		}

	}
</script>

</head>
<body>
	<button type="button" class="close glyphicon glyphicon-remove"
		data-dismiss="modal" aria-hidden="true" id="closeBtn1"></button>
	<div class="modal-body" id="imgModal_main">
		<input type="hidden" value="0" id="imgboard_num">

		<!-- 	carousel를 사용하기 위해서는 class에 carousel와 slide 설정한다.
			carousel는 특이하게 id를 설정해야 한다. -->
		<div id="carousel-example-generic" class="carousel slide">
			<!-- carousel의 지시자
				지시자라고는 하는데 ol태그의 class에 carousel-indicators를 넣는다. -->
			<ol class="carousel-indicators" id="carousel_indicators">
				<!-- li는 이미지 개수만큼 추가하고 data-target은 carousel id를 가르킨다.
					data-slide-to는 순서대로 0부터 올라가고 0은 active를 설정한다.
					딱히 이 부분은 옵션별로 설정하게 없다. -->
			</ol>
			<!-- 실제 이미지 아이템
				class는 carousel-inner로 설정하고 role은 listbox에서 설정한다. -->
			<div class="carousel-inner" role="listbox" id="carousel_inner">
			</div>
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<input type="hidden" value="0" id="imgboard_num">
	<input type="hidden" value="0" id="imgboard_url">
	<script>
		$('#carousel-example-generic').carousel();

		/* $('#carousel-example-generic').on('slid.bs.carousel', function() {
			// 회전식 슬라이드가 완료되면 호출된다.
		});
		// 이미지 슬라이드 전 페이지 이동
		$("#carousel_prev").on("click", function() {
			$('#carousel-example-generic').carousel('prev');
		});

		// 이미지 슬라이드 다음 페이지 이동
		$("#carousel_next").on("click", function() {
			$('#carousel-example-generic').carousel('next');
		}); */
	</script>


</body>
</html>