package com.example.synthesisClass.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.synthesisClass.dto.Member;

@Mapper
public interface MemberMapper {
	int updateActiveOntoOff();
	
	Member selectActiveByOff();
	
	int findMemberPw(Member member);

}
