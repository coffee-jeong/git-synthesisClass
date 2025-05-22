<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 	<script>
 		$(function() {
 			let isDuplicate = false;
 			
			$('#chBtn').click(function() {
				const id = $('#id').val().trim();
				if(id == '') {
					alert('아이디를 입력하세요')
					return;
				} 
				
				$.ajax({
					url: '/checkId',
					type: 'get',
					data: {id: id},
					success: function(chId) {
						if(chId.duplicated) {
							alert('이미 사용중인 아이디입니다.');
							return;
						} else {
							alert('사용가능한 아이디입니다.');
						}
					}
				});
			});
			
			$('#pw').blur(function() {
				const pw = $('#pw').val().trim();
				if(pw < 4) {
					alert('비밀번로를 4자 이상 입력하세요');
					return;
				}
			});
			
			$('#btn').click(function() {
				const id = $('#id').val().trim();
				const pw = $('#pw').val().trim();
				const email = $('#email').val().trim();
				
				if(!$('#chBtn').click) {
					alert('아이디 중복을 확인해주세요');
				}
				
				// 아이디, 비밀번호 공백검사
				if(id == '' || pw == '') {
					alert('아이디 또는 비밀번호를 입력해주세요');
					return;
				} else if(id.length < 4 || pw.length < 4) {
					alert('아이디와 비밀번호를 4자이상 입력해주세요');
					return;
				} 
				// 이메일 유효성 검사
	            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	            if (!emailRegex.test(email)) {
	                alert('올바른 이메일 형식을 입력하세요');
	                return;
	            }
	            
				$('#joinMember').submit();
			});
			
 		});
 	</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/joinMember" method="post" id="joinMember">
		<div>
			<div>
				아이디: <input type="text" id="id" class="id" name="id">
				<button id="chBtn" type="button">중복확인</button>
			</div>
			
			<div>
				비밀번호: <input type="password" id="pw" class="pw" name="pw">
			</div>
			
			<div>
				이메일: <input type="email" id="email" class="email" name="email">
			</div>
		</div>
			<button id="btn" type="button">회원가입</button>
	</form>
</body>
</html>