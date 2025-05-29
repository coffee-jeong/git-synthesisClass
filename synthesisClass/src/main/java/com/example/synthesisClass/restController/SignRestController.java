package com.example.synthesisClass.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.synthesisClass.service.DocumentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SignRestController {
	@Autowired DocumentService documentService;
	
	@PostMapping("/admin/adminSignForm")
	public String adminSign(@RequestParam("docNo") int docNo, Model model) {
        model.addAttribute("docNo", docNo);
        return "admin/signForm"; // signForm.jsp
	}
	
	@PostMapping("/signForm")
    @ResponseBody
    public String saveSign(@RequestParam("docNo") int docNo,
                           @RequestParam("signImg") String signImg) {
		// 예: signImg는 base64 PNG URL 문자열입니다.
        // 실제로는 여기서 DB에 저장하거나 파일로 저장하거나 합니다.
        log.info("문서 번호: " + docNo);
        log.info("서명 이미지: " + signImg.substring(0, 100)); // 앞부분만 출력

        // 저장 로직 추가 가능
        return "서명이 저장되었습니다.";
    }
}
