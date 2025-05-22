<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<form action="/member/deleteMember" method="post">
		<div>
			아이디 : <input type="text" id="id" name="id" value="${id}" readonly>
		</div>
		
		<div>
			비밀번호 : <input type="password" id="pw" name="pw">
		</div>
		
		<button type="submit">탈퇴하기</button>
	</form>
</body>
</html>