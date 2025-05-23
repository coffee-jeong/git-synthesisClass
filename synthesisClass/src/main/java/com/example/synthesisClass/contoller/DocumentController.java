package com.example.synthesisClass.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentController {
	
	@GetMapping("/employee/document")
	public String document() {
		return "/employee/document";
	}
	
	@GetMapping("/admin/signForm")
	public String adminSignForm() {
		return "/admin/signForm";
	}
	
	@GetMapping("/owner/signForm")
	public String ownerSignForm() {
		return "/owner/signForm";
	}
	
}
