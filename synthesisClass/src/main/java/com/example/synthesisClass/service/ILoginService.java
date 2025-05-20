package com.example.synthesisClass.service;

import java.util.List;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;

public interface ILoginService {
	Member login(Member parmMember);

	void insertLoginHistory(Member member);
	
	List<LoginHistory> selectLoginHistory(String id);
}
