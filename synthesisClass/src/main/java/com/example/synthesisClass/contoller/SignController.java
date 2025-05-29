package com.example.synthesisClass.contoller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.service.SignService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SignController {
	@Autowired SignService signService;
	
	@PostMapping("/sign/submit")
	public String submitSignature(@RequestParam int docNo,
	                              @RequestParam String role,
	                              @RequestParam String signatureData,
	                              HttpServletRequest request) throws IOException {
		
	    HttpSession session = request.getSession(false);
	    if (session == null) return "redirect:/login";

	    Member loginMember = (Member) session.getAttribute("loginMember");
	    if (loginMember == null) return "redirect:/login";

	    String userId = loginMember.getId();
	    String fileName = signService.saveSignatureImage(signatureData, docNo, role); // 파일 저장

	    if ("admin".equals(role)) {
	        signService.adminSign(docNo, userId, fileName); // admin 서명 처리
	        signService.completeIfBothSigned(docNo);
	    } else if ("owner".equals(role)) {
	        if (!signService.isAdminSigned(docNo)) {
	            return "redirect:/error?msg=관리자 결제 후 대표 서명 가능"; // admin 미서명 시 제한
	        }
	        signService.ownerSign(docNo, userId, fileName); // owner 서명 처리
	    }

	    // 🔹 5. 둘 다 서명했는지 확인하고 완료 처리
	    signService.completeIfBothSigned(docNo);
	    
	    return "redirect:/employee/documentOne?no=" + docNo;
	}

}
