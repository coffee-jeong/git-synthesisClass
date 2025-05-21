package com.example.synthesisClass.service;

import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.Member;

@Service
public interface IMemberService {
	// 마지막 접속이 1년 경과시 휴면계정으로 변경
	int updateActiveOntoOff();
	
	void findMemberPw(Member member);
	
	// 임시비밀번호로 비밀번호 변경
	int rechangeMemberPw(Member member, String id, String pw, String newPw);

	// 상세정보
	Member selectMemberOne(String id);
	
	// 비밀번호 수정
	int modifyMemeber(Member member, String id, String pw, String newPw);
	
	// 회원탈퇴
	int deleteMember(Member member, String id, String pw);
}
