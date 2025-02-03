package com.min.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
// TODO 003 Controller 작성  
@Controller
@Slf4j
public class HomeController {

//	private Logger log = LoggerFactory.getLogger(this.getClass()); org.slf4j.Logger -> @Slf4j 
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home() {
		log.info("[GET] - /main.do ");
		log.info("첫 요청 페이지");
		return "home";
	}
}