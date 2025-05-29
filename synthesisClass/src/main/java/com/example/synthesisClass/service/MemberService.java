package com.example.synthesisClass.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.synthesisClass.dto.Page;
import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.dto.PwHistory;
import com.example.synthesisClass.mapper.LoginMapper;
import com.example.synthesisClass.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberService implements IMemberService{
	@Autowired MemberMapper memberMapper;
	@Autowired JavaMailSender javaMailSender;
	@Autowired LoginMapper loginMapper;

	// 마지막 접속이 1년 경과시 휴면계정으로 변경
	@Override
	public int updateActiveOntoOff() {
		
		return memberMapper.updateActiveOntoOff();
	}
	
	// 비밀번호 찾기 -> 임시 비밀번호 메일 발송
	@Override
	public void findMemberPw(Member member) {
		String randomPw = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		member.setPw(randomPw);
		memberMapper.updateTemporaryPassword(member.getId(), randomPw, LocalDateTime.now());

		log.info("변경된 임시 비밀번호: {}", randomPw);
		int row = memberMapper.findMemberPw(member);
		log.info("비밀번호 업데이트 시도, row: {}", row);
		if(row == 1) {
			log.info("변경된 임시 비밀번호: " + randomPw);
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@gmail.com");
			msg.setTo(member.getEmail());
			msg.setSubject("임시비밀번호입다:" + member.getPw());
			msg.setText("10분안에 비밀번호를 변경하세요");
			
			javaMailSender.send(msg);
		}
		
	}
	
	
	// 임시비밀번호로 비밀번호 변경
	@Override
	public int rechangeMemberPw(Member member, String id, String pw, String newPw) {
		log.info("임시비밀번호 비밀번호 변경 시도: id={}, pw={}, newPw={}", id, pw, newPw);
		int row = memberMapper.rechangeMemberPw(member);
		log.info("서비스 임시비밀번호로 pw변경" + row);
		log.info("비밀번호 변경 결과 row={}", row);
		log.info("member 객체 상태: {}", member);
		
		// 히스토리에 비밀번호 변경 내역 저장
		if(row == 1) {
	        PwHistory history = new PwHistory();
	        history.setId(id);
	        history.setPw(newPw);
	        loginMapper.insertPwHistory(history);
		}
        return row;
	}
	
	//상세정보
	@Override
	public Member selectMemberOne(String id) {
		
		return memberMapper.selectMemberOne(id);
	}
	
	// 비밀번호 수정
	@Override
	public int modifyMemeber(Member member, String id, String pw, String newPw) {
		log.info("비밀번호 변경 시도: id={}, pw={}, newPw={}", id, pw, newPw);
		int row = memberMapper.modifyMemeber(member);
		log.info("비밀번호 변경 결과", row);
		
		// 히스토리에 비밀번호 변경 내역 저장
		if(row == 1) {
	        PwHistory history = new PwHistory();
	        history.setId(id);
	        history.setPw(newPw);
	        loginMapper.insertPwHistory(history);
		}
		return row;
	}
	
	// 회원탈퇴
	@Override
	public int deleteMember(Member member, String id, String pw) {
		log.info("회원탈퇴 시도: id={}, pw={} ", id, pw);
		
		int row = memberMapper.deleteMember(member);
		log.info("탈퇴 여부 row={} ", row);
		
		return row;
	}

	// 비밀번호 변경 히스토리 삭제
	@Override
	public int deletePwHistory() {
		
		return memberMapper.deletePwHistory();
	}

	// 멤버 리스트 
	@Override
	public List<Member> selectMemberList(Page page) {
		 return memberMapper.selectMemberList(page);
	}

	@Override
	public int totalCount(String searchWord) {
		return memberMapper.totalCount(searchWord);
	}

}
