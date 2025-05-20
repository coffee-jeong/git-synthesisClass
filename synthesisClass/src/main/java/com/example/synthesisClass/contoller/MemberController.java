package com.example.synthesisClass.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	
	// 비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw() {
		return "findPw";
	}
	
	// 임시비밀번호 메일 전송 
	@PostMapping("/findPw")
	public String findPw(Member member) {
		//비밀번호 변경
		memberService.findMemberPw(member);
		
		return "rechangeMemberPw";
	}
	
	@GetMapping("/rechangeMemberPw")
	public String rechangeMemberPw() {
		return "rechangeMemberPw";
		
	}
	
	@PostMapping("rechangeMemberPw")
	public String postMethodName() {
		
		return "/index";
	}
	
}
