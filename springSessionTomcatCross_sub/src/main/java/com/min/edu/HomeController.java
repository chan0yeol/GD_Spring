package com.min.edu;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class); 
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {
		log.info("클러스터링 객체를 대상 tomcat의 application context에서 가지고 온다.");
		String rootScope = (String)request.getSession().getServletContext()
				.getContext("/springSessionTomcatCross_root").getAttribute("loginInfo");
		log.info(rootScope);
		if(rootScope == null) {
			log.info("Root에서 로그인을 하지 않음");
			return "index";
		} else {
			log.info("Root에서 로그인 정보 확인 ");
			model.addAttribute("loginInfoRoot", rootScope);
			return "home";
		}
	}
}
