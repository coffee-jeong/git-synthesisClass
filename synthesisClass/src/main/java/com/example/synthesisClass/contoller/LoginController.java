package com.example.synthesisClass.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.mapper.LoginMapper;
import com.example.synthesisClass.service.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired LoginMapper loginMapper;
	@Autowired LoginService loginService;
	
	// 인덱스, 메인페이지
	@GetMapping({"/", "/index"}) 
	public String index() {
		return "/index";
	}
	// 회원가입
	@GetMapping("joinMember")
	public String joinMember() {
		return "/joinMember";
	}

	@PostMapping("joinMember")
	public String joinMember(Member member, Model model) {
		int row = loginMapper.joinMember(member);
		if(row == 1) {
			model.addAttribute("msg", "회원가입 성공");
			log.info("회원가입 성공:" + row);
			return "/joinMember";
		} else {
			log.info("회원가입 실패:" + row);
			model.addAttribute("msg", "회원가입 실패");
			return "/joinMember";
		}
	}
	
	// 로그인
	@GetMapping("login")
	public String login() {
		return "/login";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
	
	@PostMapping("login") 
	public String login(Member member, Model model, HttpSession session) {
		Member loginMember  = loginService.login(member);
		if(loginMember  != null) {
			session.setAttribute("id", member.getId());
			loginService.insertLoginHistory(loginMember);
			return "/index";
		} else {
			model.addAttribute("error", "로그인 실패");
			return "/login";
		}
	}
	
	// 로그인 히스토리
	@GetMapping("admin/loginHistory")
	public String loginHistory(Model model, @RequestParam(value = "id", required = false) String id) {
		List<LoginHistory> loginHistoryList = loginService.selectLoginHistory(id);
		model.addAttribute("loginHistoryList", loginHistoryList);
		model.addAttribute("id", id);
		return "/admin/loginHistory";
	}
	
}
