package com.example.synthesisClass.dto;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private String email;
	private String active;
	private String newPw;
	private String pwcktime;
	private String role;
}
