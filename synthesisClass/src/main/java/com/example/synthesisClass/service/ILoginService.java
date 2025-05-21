package com.example.synthesisClass.service;

import java.util.List;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.dto.PwHistory;

public interface ILoginService {
	Member login(Member parmMember);

	void insertLoginHistory(Member member);
	
	List<LoginHistory> selectLoginHistory(String id);

	void insertPwHistory(PwHistory pwHistory);
}
