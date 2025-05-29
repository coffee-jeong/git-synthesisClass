package com.example.synthesisClass.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.synthesisClass.dto.Document;
import com.example.synthesisClass.dto.Page;
import com.example.synthesisClass.mapper.DocumentMapper;
import com.example.synthesisClass.service.DocumentService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class DocumentController {
	@Autowired DocumentMapper documentMapper;
	@Autowired DocumentService documentService;
	
	@GetMapping("/employee/document")
	public String document() {
		return "/employee/document";
	}
	
	@PostMapping("/employee/document")
	public String document(Document document, Model model) {
		int row = documentMapper.insertAddDocument(document);
		if(row == 1) {
			model.addAttribute("msg", "문서 작성 성공");
			log.info("문서작성 성공:" + row);
			return "/index";
		} else {
			log.info("문서작성 실패:" + row);
			model.addAttribute("msg", "작성 실패");
			return "/employee/document";
		}
	}
	
	@GetMapping("/employee/documentList")
	public String documentList(Model model, Document document
							,@RequestParam(defaultValue = "1") int page
							,@RequestParam(defaultValue = "10") int size
							,@RequestParam(defaultValue = "") String searchWord
							,@RequestParam(defaultValue = "title") String searchType) {
		log.info("검색어: " + searchWord);
		log.info("검색 타입: " + searchType);
		
		Page paging = new Page(size, page, 0, searchWord, searchType);
	    int totalCount = documentService.totalCount(paging);
		paging.setTotalCount(totalCount);
		
		
		List<Document> documentList = documentService.selectDocumentList(paging);
		model.addAttribute("documentList", documentList);
		model.addAttribute("page", paging);
		return "/employee/documentList";
	}
	
	// 리스트 상세보기
	@GetMapping("/employee/documentOne")
	public String documentOne(Model model, @RequestParam(value="no") int no) {
		Document document = documentService.selectDocumentOne(no);
		model.addAttribute("document", document);
		return "/employee/documentOne";
	}
	
	// 결제서류 수정
	@GetMapping("/employee/modifyDocument")
	public String modifyDocument(@RequestParam("no") int no, Model model) {
		Document document = documentService.selectDocumentOne(no); // 해당 문서 가져오기
	    model.addAttribute("document", document);
		return "/employee/modifyDocument";
	}
	
	@PostMapping("/employee/modifyDocument")
	public String modifyDocument(Document document) {
		int row = documentService.modifyDocument(document);
		if(row != 1) {
			log.info("수정실패");
			return "redirect:/employee/modifyDocument";
		} else {
			return "/employee/documentOne";
		}
	}

	// 결제서류 삭제
	@GetMapping("/employee/deleteDocument")
	public String deleteDocument(Document document) {
		int row = documentService.deleteDocument(document);
		if(row != 1) {
			log.info("삭제실패");
			return "/employee/deleteDocument";
		} else {
			return "redirect:/employee/documentList";
		}
	}
	
	// 사인
	@GetMapping("/signForm")
	public String signForm() {
		return "/signForm";
	}

}
