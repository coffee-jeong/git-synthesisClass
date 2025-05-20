<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<form method="post" action="/rechangeMemberPw">
		<div>
			ID: <input type="text" name="id">
		</div>
		
		<div>
			임시비밀번호: <input type="password" name="pw">
		</div>
		
		<div>
			새로운 비밀번호: <input type="password" name="newPw">
		</div>
		<button type="submit">비밀번호 변경</button>
	</form>
</body>
</html>