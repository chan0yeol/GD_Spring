package com.min.edu.ctrl;

import java.lang.ProcessHandle.Info;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.IBoardService;

import lombok.extern.slf4j.Slf4j;
// TODO 10617 Controller 작성
@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	@GetMapping("/selectBoard.do")
	public String selectBoard(Model model) {
		log.info("Welcome BoardController selectBoard.do GET ");
		List<BoardDto> lists = boardService.selectBoard();
		model.addAttribute("lists",lists);
		return "boardList";
	}
	@PostMapping("/insertBoardDto.do")
	public String insertBoardDto(BoardDto dto) {
		log.info("Welcome BoardController DTO를 통해서 전달 받은  값을 setter를 통해서 객체로 만들어 준다. : {} ", dto);
		int n = boardService.insertBoard(dto);
		if (n==1) {
			return "redirect:/selectBoard.do";
		}
		return "error";
	}
	@PostMapping("/insertBoardMap.do")
	public String insertBoardMap(@RequestParam Map<String, Object> map) {
		log.info("Welcome BoardController @RequestParam Map을 통해서 화면에 name을 키로 사용하여 객체를 생성 : {} ", map);
		int n = boardService.insertBoard(map);
		if (n==1) {
			return "redirect:/selectBoard.do";
		}
		return "error";
	}
	
	/* 
	 * @RequestParam은 화면에서 요청한 값을 처리해주는 Annotation
	 * 1) @RequestParam Map/List 전달받을 해당 객체를 생성
	 * 2) @RequestParam(value="화면의 name"), defaultValue="null or 1") String 변수명 
	 * 		화면에서 전달하는 form요소의 name과 매핑되는 변수명과 같다면 그냥 사용하면 되지만
	 * 		지금 화면의 name과 내부에서 사용하는 변수명이 다른 경우에 처리할 수 있다.
	 * 3)  @RequestParam(value="화면의 name"), defaultValue="null or 1") String 변수명 
	 * 		화면에서 전달하는 form요소의 name이 없다면 오류를 발생 시킨다. (String 제외) defaultValue 값이 없을 경우 초기 값을 지정
	 */

	@PostMapping("/parameterName.do")
	public String parameterName( @RequestParam(name="a") String id, 
									@RequestParam(name="b") String title,
									@RequestParam(name="c") String content,
									@RequestParam(value ="page", defaultValue = "1") int page,
									@RequestParam(value="check", required = false ) String check) {
		log.info("Welcom BoardController @RequestParam name 변경하여 받기");
		log.info("변경된 변수 a : {}, b:{}, c:{}",id,title,content);
		log.info("요청이 없는 page의 값처리 : {} ", page);
		log.info("요청이 없는 check의 required 처리 {}", check);
//		return "redirect:/selectBoard.do";
		return null;
	}
	
	@GetMapping("/com/min/edu/{user}/pathVariable.do")
	public String pathVariable(@PathVariable("user") String path) {
		log.info("Welcom BoardController @PathVariable를 통한 주소에서 값 추출 : {} ",path);
		return path+"/pathVariable"; // /WEB-INF/views/user/pathVariable.jsp
	}
	
	
	
	
	
	
}
