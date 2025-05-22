package com.example.synthesisClass.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String postMethodName(@RequestParam ("id") String id
								, @RequestParam ("pw") String pw
								, @RequestParam ("newPw") String newPw) {
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setNewPw(newPw);
		
		int row = memberService.rechangeMemberPw(member,  id,  pw,  newPw);
		
		if(row == 1) {
			return "redirect:/login";
		} else {
			return "redirect:/rechangeMemberPw";
		}
	}
	
	// 상세정보
	@GetMapping("member/memberOne")
	public String memberOne(Model model, @RequestParam(value = "id") String id) {
		Member member = memberService.selectMemberOne(id);
		model.addAttribute("member", member);
		return "member/memberOne";
	}
	
	// 비밀번호 수정
	@GetMapping("member/modifyMember")
	public String modifyMember() {
		return "member/modifyMember";
	}
	
	@PostMapping("member/modifyMember")
	public String modifyMember(@RequestParam(value = "id") String id
								, @RequestParam(value = "newPw") String newPw
								, @RequestParam(value = "pw") String pw) {
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setNewPw(newPw);
		
		int row = memberService.modifyMemeber(member,  id,  pw,  newPw);
		
		if(row == 1) {
			return "redirect:/login";
		} else {
			return "redirect:/member/modifyMember";
		}
		
	}
	
	// 회원탈퇴
	@GetMapping("member/deleteMember")
	public String deleteMember() {
		return "/member/deleteMember";
	}
	
	@PostMapping("member/deleteMember")
	public String deleteMember(@RequestParam(value = "id") String id
								, @RequestParam(value = "pw") String pw) {
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		int row = memberService.deleteMember(member, id, pw);
		if(row == 1) {
			return "redirect:/index";
		}
		return "redirect:/login";
	}
	
	// 회원리스트
	@GetMapping("/admin/memberList")
	public String selectMemberList(Model model, Member member) {
		List<Member> memberList = memberService.selectMemberList();
		model.addAttribute("memberList", memberList);
		return "/admin/memberList";
	}
}
