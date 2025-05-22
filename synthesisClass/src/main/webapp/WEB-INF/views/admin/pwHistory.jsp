<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>최근 비밀번호 변경이력</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>변경 시간</th>
		</tr>
		<c:forEach var="pwHistory" items="${pwHistoryList}">
		<tr>
			<td>${pwHistory.id}</td>
			<td>${pwHistory.changeDate}</td>
		</tr>
		</c:forEach>
	</table>
	
	<form method="get" action="/admin/pwHistory">
		아이디 : <input type="text" id="serchWord" name="serchWord" placeholder="아이디 검색">
		<button type="submit">검색하기</button>
	</form>
</body>
</html>