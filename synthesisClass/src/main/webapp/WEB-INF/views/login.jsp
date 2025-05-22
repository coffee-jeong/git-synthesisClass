<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function(){
			const id = $('#id').val().trim();
			const pw = $('#pw').val().trim();
			if(id == '' || pw == '') {
				alert('아이디 또는 비밀번호를 입력해주세요.');
				return;
			} 
				// 아이디 혹은 비밀 번호중 하나라도 틀리면
			
			$('#login').submit();
		});
	
	});
</script>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="/login" id="login">
		<div>
			<div>
				아이디 : <input type="text" id="id" name="id">
			</div>
			
			<div>
				비밀번호 : <input type="password" id="pw" name="pw">
			</div>
		</div>
		<button id="btn" type="button">로그인</button>
	</form>
	<div><a href="/joinMember">회원가입</a></div>
</body>
</html>