<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 기록</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>로그인 기록</th>
		</tr>
		<c:forEach var="loginHistory" items="${loginHistoryList}">
		<tr>
			<td>${loginHistory.id}</td>
			<td>${loginHistory.logindate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>