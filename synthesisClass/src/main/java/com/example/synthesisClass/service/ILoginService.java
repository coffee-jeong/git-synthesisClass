package com.example.synthesisClass.service;

import java.util.List;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.dto.PwHistory;

public interface ILoginService {
	Member login(Member parmMember);

	// 로그인 히스트로 db저장
	void insertLoginHistory(Member member);
	
	// 로그인 히스토리 리스트
	List<LoginHistory> selectLoginHistory(String id);

	// 비밀번호 변경 히스토리 저장
	void insertPwHistory(PwHistory pwHistory);
	

	public String selectId(String id);
}
