package com.example.synthesisClass.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.synthesisClass.dto.Member;

@Mapper
public interface MemberMapper {
	int updateActiveOntoOff();
	
	Member selectActiveByOff();
	
	int findMemberPw(Member member);
	
	// 임시 비빌번호로 비밀번호 변경
	int rechangeMemberPw(Member member);
	
	// 임시번호 발송시 member테이블에 시간저장(10분내 변경을 위해)
	int updateTemporaryPassword(@Param("id") String id, @Param("pw") String pw, @Param("pwcktime") LocalDateTime pwcktime);
	
	// 상세정보
	Member selectMemberOne(@Param("id") String id);
	
	// 비밀번호 변경
	int modifyMemeber(Member member);
	
	// 회원탈퇴
	int deleteMember(Member member);

}
