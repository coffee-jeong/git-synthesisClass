package com.example.synthesisClass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.synthesisClass.dto.LoginHistory;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.dto.PwHistory;

@Mapper
public interface LoginMapper {
	int joinMember(Member member);
	
	Member login(Member paramMember);
	
	// 로그인 히스토리 저장
	int insertLoginHistory(Member member);
	
	// 로그인 히스토리 리스트
	List<LoginHistory> selectLoginHistory(String id);
	
	// 비밀번호 히스토리 저장
	int insertPwHistory(PwHistory pwHistory);
	
	// 아이디 중복 체크
	@Select("SELECT id FROM member WHERE id = #{id}")
	public String selectId(String id);
	
	// 비밀번호 변경 리스트
	List<PwHistory> selectPwHistory(String id);

}
