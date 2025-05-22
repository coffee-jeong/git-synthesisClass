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
	
	int insertLoginHistory(Member member);
	
	List<LoginHistory> selectLoginHistory(String id);
	
	int insertPwHistory(PwHistory pwHistory);
	
	@Select("SELECT id FROM member WHERE id = #{id}")
	public String selectId(String id);

}
