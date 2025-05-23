<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<ul>
		<c:choose>
			<c:when test="${not empty sessionScope.loginMember}">
				<li>${sessionScope.loginMember.id}님 반갑습니다.</li>
				<li><a href="/index">홈</a></li>
				<li><a href="/logout">로그아웃</a></li>
				<li><a href="/member/memberOne?id=${sessionScope.loginMember.id}">정보보기</a></li>
				<c:if test="${sessionScope.loginMember.role == 'ADMIN' || sessionScope.loginMember.role == 'EMPLOYEE' || sessionScope.loginMember.role == 'OWNER'}">
					<li><a href="/employee/memberList">회원리스트</a></li>
					<li><a href="/employee/document">결제서류 작성</a></li>
					<li><a href="/admin/loginHistory?id=${sessionScope.loginMember.id}">로그인 히스토리</a></li>
					<li><a href="/admin/pwHistory?id=${sessionScope.loginMember.id}">비밀번호 변경 히스토리</a></li>
				</c:if>
			</c:when>
			<c:otherwise>
				<li><a href="/login">로그인</a></li>
				<li><a href="/findPw">비밀번호찾기</a></li>
				<li><a href="/joinMember">회원가입</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
</body>
</html>