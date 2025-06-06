package com.example.synthesisClass.dto;

import lombok.Data;

@Data
public class Page {
	private int rowPerPage;
	private int currentPage;
	private int BeginRow;
	private int totalCount;
	private String searchWord; // 검색어
	private String searchType; // 검색타입
	
	public Page(int rowPerPage, int currentPage, int totalCount, String searchWord) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.searchWord= searchWord;
		this.BeginRow = (currentPage - 1) * rowPerPage;
	}
	
	public Page(int rowPerPage, int currentPage, int totalCount, String searchWord, String searchType) {
	    this(rowPerPage, currentPage, totalCount, searchWord);
	    this.searchType = searchType;
	}
	
	public int getLastPage() {
		int lastPage = this.totalCount / this.rowPerPage;
		if(this.totalCount % this.rowPerPage != 0) {
			lastPage += 1;
		}
		return lastPage;
	}
}
