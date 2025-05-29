package com.example.synthesisClass.dto;

import lombok.Data;

@Data
public class Document {
	private int no;
	private String id;
	private String title;
	private String content;
	private String writedate;
	private String status;
	private boolean adminSigned;
    private boolean ownerSigned;
}
