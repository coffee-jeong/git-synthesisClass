package com.example.synthesisClass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.Document;
import com.example.synthesisClass.dto.Page;

@Service
public interface IDocumentService {
	void addDocument(Document document);
	
	// 리스트(페이징) 및 검색
	List<Document> selectDocumentList(Page page);
	int totalCount(Page page);
	
	/** 상세보기 **/
	Document selectDocumentOne(int no);
	
	/** 서류수정 **/
	int modifyDocument(Document document);
	
	/** 서류삭제 **/
	int deleteDocument(Document document);
	
	Document getDocument(int docNo);
}
