<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/signature_pad@4.0.0/dist/signature_pad.umd.min.js"></script>
</head>
<body>
	<canvas id="signature-pad" width="400" height="200" style="border:1px solid black;"></canvas>
	<form id="signForm" method="post" action="/sign/submit" enctype="multipart/form-data">
	    <input type="hidden" name="docNo" value="${param.docNo}" />
	    <input type="hidden" name="role" value="${userRole}" /> <!-- admin or owner -->
	    <input type="hidden" id="signatureData" name="signatureData" />
	    <button type="button" onclick="pad.clear()">지우기</button>
	    <button type="button" onclick="submitSignature()">사인 제출</button>
	</form>
	
	<script>
	    const pad = new SignaturePad(document.getElementById("signature-pad"));
	    function submitSignature() {
	        if (pad.isEmpty()) {
	            alert("서명을 입력해주세요.");
	            return;
	        }
	        const dataURL = pad.toDataURL();
	        document.getElementById("signatureData").value = dataURL;
	        document.getElementById("signForm").submit();
	    }
	</script>

</body>
</html>