package com.min.edu;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home(Model model, Locale locale) {
		log.info("HomeController home GET : {} ", locale);
		
		Date date = new Date();
		model.addAttribute("serverTime",date.toLocaleString());
		
		return "home";
	}
}
