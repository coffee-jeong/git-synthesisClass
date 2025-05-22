<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<form method="post" action="findPw">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="email" id="email" name="email"></td>
			</tr>
		</table>
		<button type="submit">비밀번호 찾기</button>
	</form>
</body>
</html>