package com.min.edu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {
	
	private final IBoardService service;
	
	@GetMapping("/home.do")
	public String home() {
		log.info("BoardController /home.do GET 요청");
		return "home";
	}
	
	/*
	 * 이전의 cache 삭제 response에서 Pragma, Cache-Control, Expires 
	 */
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		log.info("BoardController /boardList.do GET ");
		/*
		 * 캐쉬 삭제 코드 작성
		 */
		List<BoardVo> boardList = service.userBoardList();
		model.addAttribute("boardList",boardList);
		return "boardList";
	}
	
	@RequestMapping(value = "/multiDelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String multiDelete(@RequestParam List<String> chkVal) {
		log.info("BoardController /multiDelete.do GET or POST ");
		log.info("Param : List {}", chkVal);
		int n = service.delflagBoard(chkVal);
		log.info("다중 삭제 된 Row : {}", n);
		return "redirect:/boardList.do";
	}
}
