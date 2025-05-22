<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 리스트</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>등급</th>
			<th>활성화</th>
		</tr>
		
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.id}</td>
			<td>${member.role}</td>
			<td>${member.active}</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<form method="get" action="/admin/memberList">
		아이디 : <input type="text" id="serchWord" name="serchWord" value="${serchWord}" placeholder="아이디 검색">
		<button type="submit">검색하기</button>
	</form>
</body>
</html>