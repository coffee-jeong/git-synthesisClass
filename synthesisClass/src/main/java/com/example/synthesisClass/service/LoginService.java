package com.example.synthesisClass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.dto.PwHistory;
import com.example.synthesisClass.mapper.LoginMapper;

@Service
public class LoginService implements ILoginService{
	@Autowired LoginMapper loginMapper;
	
	
	// 로그인
	@Override
	public Member login(Member paramMember) {
          return loginMapper.login(paramMember);
    }
	
	// 로그인 히스토리
	@Override
	public void insertLoginHistory(Member member) {
		loginMapper.insertLoginHistory(member);
	}
	
	// 로그기록 리스트
	@Override
	public List<LoginHistory> selectLoginHistory(String id) {
		
		return loginMapper.selectLoginHistory(id);
	}

	// 비밀번경 히스토리 저장
	@Override
	public void insertPwHistory(PwHistory pwHistory) {
		
		loginMapper.insertPwHistory(pwHistory);
	}

	// 아이디 중복 확인
	@Override
	public String selectId(String id) {
		
		return loginMapper.selectId(id);
		
	}
	
	// 비밀번호 변경 히스토리 리스트
	@Override
	public List<PwHistory> selectPwHistory(String id) {
		
		return loginMapper.selectPwHistory(id);
	}

}
