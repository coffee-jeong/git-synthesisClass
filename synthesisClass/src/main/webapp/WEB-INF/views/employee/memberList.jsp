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
	
	<!-- 페이징 -->
	<c:forEach var="i" begin="1" end="${page.lastPage}">
	    <a href="?page=${i}&searchWord=${page.searchWord}">${i}</a>
	</c:forEach>
	
	<form method="get" action="/employee/memberList">
		아이디 : <input type="text" id="searchWord" name="searchWord" placeholder="아이디 검색">
		<button type="submit">검색하기</button>
	</form>
</body>
</html>