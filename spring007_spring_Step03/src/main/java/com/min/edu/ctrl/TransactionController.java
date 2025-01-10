package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.IBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// TODO 10703 트랜잭션 처리를 위한 Controller 작성

@Controller
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
	private final IBoardService service;
	
	
	@PostMapping("/transaction.do")
	public String transaction(BoardDto boardDto) {
		log.info("Transaction 을 통한 Dao 제어 : {}", boardDto);
		
		int n = service.transaction(boardDto);
		if(n == 1 ) {
			return "redirect:/selectBoard.do";
		} else {
			return null;
		}
	}
}
















