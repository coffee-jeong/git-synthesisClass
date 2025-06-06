<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제서류</h1>
	<table border="1">
		<tr>
			<th>관리자 결제</th>
			<td>
				<c:choose>
					<c:when test="${document.adminSigned}">승인 완료</c:when>
					<c:otherwise>
						<a href="/signForm?docNo=${document.no}&role=admin">결제하기</a>
					</c:otherwise>
				</c:choose>
			</td>
			<th>대표 결제</th>
			<td>
				<c:choose>
					<c:when test="${document.ownerSigned}">승인 완료</c:when>
					<c:otherwise>
						<a href="/signForm?docNo=${document.no}&role=owner">결제하기</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	<br>
	<!-- 상세보기 -->
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${document.no}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${document.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${document.content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${document.id}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${document.writedate}</td>
		</tr>
		
	</table>
	<a href="/employee/modifyDocument?no=${document.no}">수정하기</a>
	<a href="/employee/deleteDocument?no=${document.no}">삭제하기</a>
</body>
</html>