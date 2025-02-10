package com.min.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value(value="${envText}")
	private String envText;
	
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("사용되고 있는 DB의 환경값" + envText);
		model.addAttribute("dbConnector",envText);
		return "home";
	}
}
