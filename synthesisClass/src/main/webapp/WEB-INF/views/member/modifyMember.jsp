<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인정보 수정</h1>
	<form action="/member/modifyMember" method="post">
		<div>
			아이디 : <input type="text" id="id" name="id" value="${id}" readonly>
		</div>
		
		<div>
			이전 비밀번호 : <input type="password" id="pw" name="pw">
		</div>
		
		<div>
			새로운 비밀번호 : <input type="password" id="newPw" name="newPw">
		</div>
		
		<button type="submit">변경하기</button>
	</form>
</body>
</html>