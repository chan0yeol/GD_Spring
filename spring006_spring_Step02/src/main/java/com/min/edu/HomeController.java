package com.min.edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping( value ="/home.do")
	public String home(String name, Model model) {
		log.info("HomeController home.do");
		log.info("전달 받은 요청 값 {} ", name);
		model.addAttribute("name",name+"님 안녕하세요");
//		return null;
		return "home";
	}
	@PostMapping(path = "/info.do")
	public String info(String name, int age) {
		log.info("HomeController /info.do");
		log.info("전달 받은 요청 값 {} {}", name , age);
		return "page/info";
	}
}
