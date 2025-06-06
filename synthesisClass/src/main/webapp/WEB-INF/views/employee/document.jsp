<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	window.onload = function() {
		const today = new Date().toISOString().split('T')[0]; // 'YYYY-MM-DD'
		document.getElementById('date').value = today;
	};
</script>
</head>
<body>
	<h1>서류 작성</h1>
	
	<!-- 결제폼 -->
	<form method="post" id="document" name="document">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" id="id" name="id" value="${id}" readonly></td>
				<th>기안일자</th>
				<td><input type="date" id="date" name="date" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td colspan="3"><textarea rows="10" cols="100" id="content" name="content"></textarea></td>
			</tr>
		</table>
		<button type="submit">제출하기</button>
	</form>
</body>
</html>