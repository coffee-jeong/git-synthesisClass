package com.example.synthesisClass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.mapper.LoginMapper;

@Service
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;
	
	
	// 로그인
	@Override
	public Member login(Member paramMember) {
          return loginMapper.login(paramMember);
    }

	@Override
	public void insertLoginHistory(Member member) {
		loginMapper.insertLoginHistory(member);
	}

	@Override
	public List<LoginHistory> selectLoginHistory(String id) {
		
		return loginMapper.selectLoginHistory(id);
	}
}
