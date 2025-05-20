package com.example.synthesisClass.service;

import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.Member;

@Service
public interface IMemberService {
	// 마지막 접속이 1년 경과시 휴면계정으로 변경
	int updateActiveOntoOff();
	
	void findMemberPw(Member member);
}
