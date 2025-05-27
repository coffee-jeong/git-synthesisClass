package com.example.synthesisClass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.synthesisClass.dto.Document;
import com.example.synthesisClass.dto.Page;

@Mapper
public interface DocumentMapper {
	// 결제문서 추가
	int insertAddDocument(Document document);
	
	/** 문서 리스트 **/
	List<Document> selectDocumentList(Page page);
	
	/** 검색 **/
	int totalCount(Page page);
	
	/** 상세보기 **/
	Document selectDocumentOne(int no);
	
	/** 수정 **/
	int modifyDocument(Document document);
	
	/** 삭제 **/
	int deleteDocument(Document document);
}
