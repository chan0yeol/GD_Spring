package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// TODO 104 indexing 처리
@Controller
@Slf4j
@RequestMapping("/user")
public class IndexingController {

	
	@GetMapping("/logout.do")
	public String indexingReq() {
		log.info("IndexingController ");
		return "indexing";
	}
}
