package com.example.synthesisClass.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.synthesisClass.dto.Member;
import com.example.synthesisClass.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MemberService implements IMemberService{
	@Autowired MemberMapper memberMapper;
	@Autowired JavaMailSender javaMailSender;

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
		int row = memberMapper.findMemberPw(member);
		log.info("비밀번호 업데이트 시도, row: {}", row);
		if(row == 1) {
			log.info("변경된 임시 비밀번호: " + randomPw);
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("wkdwjdtn90@gmail.com");
			msg.setTo(member.getEmail());
			msg.setSubject("임시비밀번호입다:" + member.getPw());
			msg.setText("10분안에 비밀번호를 변경하세요");
			
			javaMailSender.send(msg);
		}
		
	}
}
