<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$('#btn').click(function() {
		const id = $('#id').val().trim();
		const pw = $('#pw').val().trim();
		const newPw = $('#newPw').val().trim();
		
		if(id == '' || pw == '' || newPw == '') {
			alert('아이디 또는 비밀번호를 입력하세요.');
			return;
		} 
		// 아이디 혹은 비밀 번호중 하나라도 틀리면
		
		$(#'rechangeMemberPw').submit();
		
	});
</script>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<form method="post" action="/rechangeMemberPw" id="rechangeMemberPw">
		<div>
			ID: <input type="text" name="id" id="id">
		</div>
		
		<div>
			임시비밀번호: <input type="password" name="pw" id="pw">
		</div>
		
		<div>
			새로운 비밀번호: <input type="password" name="newPw" id="newPw">
		</div>
		<button id="btn" type="button">비밀번호 변경</button>
	</form>
</body>
</html>