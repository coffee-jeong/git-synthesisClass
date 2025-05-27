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
}
