package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/home.do")
	public String home() {
		log.info("처음 요청되는 HomeController home.do");
		return "home";
	}
	
}
