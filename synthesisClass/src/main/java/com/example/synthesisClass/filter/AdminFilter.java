package com.example.synthesisClass.filter;

import java.io.IOException;

import com.example.synthesisClass.dto.Member;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		
		if(session == null || session.getAttribute("loginMember") == null) {
			res.sendRedirect("/login");
			return;
		}
		
		// 로그인 사용자 정보
		Object loginMember = session.getAttribute("loginMember");
		
		// 비관리자가 접근시
		if(loginMember instanceof Member) {
			Member member = (Member) loginMember;
			if(!"ADMIN".equals(member.getRole())) {
				res.sendRedirect("/index");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

}
