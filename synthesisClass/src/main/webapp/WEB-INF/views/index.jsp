<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<div><a href="/joinMember">회원가입</a></div>
	<div><a href="/login">로그인</a></div>
	<div><a href="/logout">로그아웃</a></div>
	<div><a href="/findPw">비밀번호찾기</a></div>
	<div><a href="/admin/loginHistory?id=${id}">로그인 히스토리</a></div>
</body>
</html>