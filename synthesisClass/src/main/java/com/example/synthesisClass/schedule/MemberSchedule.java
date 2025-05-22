package com.example.synthesisClass.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.synthesisClass.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemberSchedule {
	@Autowired MemberMapper memberMapper;
	
	// 1년 미접속자 active값을 ON -> OFF로 변경 지정 시간
	@Scheduled(cron = "59 59 23 25 * *")
	public void memberschedule() {
		int updateRow = memberMapper.updateActiveOntoOff();
		log.info("휴면처리된 계정 수:{}", updateRow);
	}
	
	// 최근 5건의 비밀번호 변경 이력을 제외하고 삭제
	@Scheduled(cron = "59 59 23 25 * *")
	public void pwHistory() {
		int deletePwHistory = memberMapper.deletePwHistory();
		log.info("삭제한 비밀번호 변경 이력:{}", deletePwHistory);
	}
}
