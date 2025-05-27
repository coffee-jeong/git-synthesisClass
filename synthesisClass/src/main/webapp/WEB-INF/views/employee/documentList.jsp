<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문서 리스트</h1>
	
	<table border="1">
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>상태</th>
		</tr>
		
		<c:forEach var="document" items="${documentList}">
		<tr>
			<td>${document.no}</td>
			<td>
				<a href="/employee/documentOne?no=${document.no}">${document.title}</a>
			</td>
			<td>${document.id}</td>
			<td>${document.writeDate}</td>
			<td>${document.status}</td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 -->
	<c:forEach var="i" begin="1" end="${page.lastPage}">
	    <a href="?page=${i}&searchWord=${page.searchWord}">${i}</a>
	</c:forEach>
	
	<form method="get" action="/employee/documentList">
		<select name="searchType">
			<option value="title" ${request.searchType == 'title' ? 'selected' : ''}>제목</option>
			<option value="id" ${request.searchType == 'id' ? 'selected' : ''}>작성자</option>
		</select>
			<input type="text" name="searchWord" value="${param.searchWord}" />
			<button type="submit">검색</button>
	</form>
</body>
</html>