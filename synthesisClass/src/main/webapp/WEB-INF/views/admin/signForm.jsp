<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/signature_pad@4.1.7/dist/signature_pad.umd.min.js"></script>
<!-- SignaturePad API설명은 https://github.com/szimek/signature_pad 페이지 readme파일 API부분참고 -->
<script>
	$(function() {
		const signaturePad = new signaturePad($('canvas')[0]), { //여러 canvas가 있을 수 있으므로 첫번째 인덱스 값을 가져온다
			inWidth: 2,
		    maxWidth: 2,
		    penColor: "rgb(0, 0, 0)"
		}
		
		// 각 버튼 기능
		$('#btnClear').click(function() {
			signaturePad.clrear();
		});
		
		$('#btnSign').click(function() {
			if(signaturePad.isEmpty()) { // 사인이 없다면
				alert('결제가 누락되었습니다.');
			} else {
				$.ajax({
					async : true
					, url : '/addSign'
					, type : 'post'
					, data : {
						id : $('#id').text()
						, signImg : signaturePad.toDataURL()
					}
				}).done(function(data) {
					alert(data);
				}).fail(function() {
					alert('결제 실패')
				});
			}
		});
		
	});
</script>
</head>
<body>
	<!-- id :  사인 레벨이 되는 로그인 사용자 id -->
	<div id="id">admin결제</div>
	<canvas style="border: 1px solid #000000;"></canvas>
	<br>
	<button type="button" id="btnClear">지우기</button>
	<button type="button" id="btnSign">결제</button>
</body>
</html>