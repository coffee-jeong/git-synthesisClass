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
	
	@Scheduled(cron = "59 59 23 25 * *")
	public void memberschedule() {
		int updateRow = memberMapper.updateActiveOntoOff();
		log.info("휴면처리된 계정 수:", updateRow);
	}
}
