package com.example.synthesisClass.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Game {
	
	@GetMapping("/game/lotto")
	private String lotto() {
		return "/game/lotto";
	}
}
