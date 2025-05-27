package com.example.synthesisClass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.synthesisClass.dto.Document;
import com.example.synthesisClass.dto.Page;
import com.example.synthesisClass.mapper.DocumentMapper;

@Service
public class DocumentService implements IDocumentService{
	@Autowired DocumentMapper documentMapper;
	
	/** 결제문서 등록 **/
	@Override
	public void addDocument(Document document) {
		documentMapper.insertAddDocument(document);
	}

	/** 문서리스트 **/
	@Override
	public List<Document> selectDocumentList(Page page) {
		return documentMapper.selectDocumentList(page);
	}
	
	/** 검색 **/
	@Override
	public int totalCount(Page page) {
		return documentMapper.totalCount(page);
	}

	/** 리스트 상세보기 **/
	@Override
	public Document selectDocumentOne(int no) {
		
		return documentMapper.selectDocumentOne(no);
	}
	
	/** 수정하기 **/
	@Override
	public int modifyDocument(Document document) {
		
		return documentMapper.modifyDocument(document);
	}

	@Override
	public int deleteDocument(Document document) {
		
		return documentMapper.deleteDocument(document);
	}
	
	
}
