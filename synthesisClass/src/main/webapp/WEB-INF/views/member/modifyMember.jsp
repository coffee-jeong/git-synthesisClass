<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#btn').click(function() {
			const pw = $('#pw').val().trim();
			const newPw = $('#newPw').val().trim();
			
			if(pw == '' || newPw == '') {
				alert('비밀번호를 입력하세요.');
				return;
			} 
			// 이전 비밀번호가 틀리면?
			
			$('#modifyMember').submit();
			
		});
	});
</script>
</head>
<body>
	<h1>개인정보 수정</h1>
	<form action="/member/modifyMember" method="post" id="modifyMember">
		<div>
			아이디 : <input type="text" name="id" value="${id}" readonly>
		</div>
		
		<div>
			이전 비밀번호 : <input type="password" id="pw" name="pw">
		</div>
		
		<div>
			새로운 비밀번호 : <input type="password" id="newPw" name="newPw">
		</div>
		
		<button id="btn" type="button">변경하기</button>
	</form>
</body>
</html>