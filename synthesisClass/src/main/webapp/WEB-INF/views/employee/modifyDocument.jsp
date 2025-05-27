<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정하기</h1>
	<form method="post" action="/employee/modifyDocument">
		<table border="1">
			<tr>
				<th>번호</th>
				<td><input type ="text" id="no" name="no" value="${document.no}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type ="text" id="title" name="title" value="${document.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="20" id="content" name="content">${document.content}</textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type ="text" id="id" name="id" value="${document.id}" readonly></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type ="text" id="writeDate" name="writeDate" value="${document.writeDate}" readonly></td>
			</tr>
		</table>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>