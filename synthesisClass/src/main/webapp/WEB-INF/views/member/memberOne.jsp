<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	
	<table border="1">
	<c:if test="${member != null}">
		<tr>
			<th>아이디 :</th>
			<td>${member.id}</td>
		</tr>
		
		<tr>
			<th>이메일 :</th>
			<td>${member.email}</td>
		</tr>
		</c:if>
	</table>
	
	<a href="/member/modifyMember?id=${id}">정보 수정</a>
	<a href="/member/deleteMember?id=${id}">회원 탈퇴</a>
</body>
</html>