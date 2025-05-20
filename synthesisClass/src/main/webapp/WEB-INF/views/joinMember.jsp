<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/joinMember" method="post">
		<div>
			<div>
				아이디: <input type="text" id="id" class="id" name="id">
			</div>
			
			<div>
				비밀번호: <input type="password" id="pw" class="pw" name="pw">
			</div>
			
			<div>
				이메일: <input type="email" id="email" class="email" name="email">
			</div>
		</div>
			<button type="submit">회원가입</button>
	</form>
</body>
</html>