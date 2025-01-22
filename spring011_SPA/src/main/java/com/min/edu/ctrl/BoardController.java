package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.UserVo;
import com.util.spring.SpringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {
	
	private final IBoardService boardService;
	
	@GetMapping("/boardListHandleBar.do")
	public String boardListHandleBar(Model model, HttpSession session,
			@RequestParam(defaultValue = "1", required = false) String page) {
		UserVo loginVo = (UserVo)session.getAttribute("loginVo");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auth", loginVo.getAuth());
		int selectPage = Integer.parseInt(page);
		log.info("현재 페이지 : {}", selectPage);
		PageVo pVo = null;
		if(session.getAttribute("row") == null) {
			pVo = new PageVo();
			session.setAttribute("row", pVo);
		} else {
			pVo = (PageVo)session.getAttribute("row");
			page = String.valueOf(pVo.getPage());
		}
		
		pVo.setTotalCount(boardService.getAllBoardCount(map));
		pVo.setCountList(10);
		pVo.setCountPage(5);
//		pVo.setTotalPage(pVo.getTotalCount());
		pVo.setTotalPage(0);
		pVo.setPage(selectPage);
//		pVo.setStagePage(selectPage);
//		pVo.setEndPage(pVo.getCountPage());
		pVo.setStagePage(0);
		pVo.setEndPage(0);

		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		map.put("last", pVo.getPage()*pVo.getCountList());
		log.info("[page] pVo : {}", pVo);
		List<BoardVo> lists = boardService.getAllBoardPage(map);
		model.addAttribute("lists",lists);
		model.addAttribute("page",pVo);
		
		return "boardListHandleBar";
	}
	
	@GetMapping("/boardList.do")
	public String boardList(Model model, HttpSession session,
							@RequestParam(defaultValue = "1", required = false) String page) {
		log.info("[GET] BoardController 게시글 전체 조회 현재페이지 : {}",page);
		
		UserVo loginVo = (UserVo)session.getAttribute("loginVo");
		log.info("[session] 로그인된 계정 정보 : {}", loginVo);
		// TODO 009 Controller에서의 페이징처리
		// 첫번째 요청의 글의 갯수
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("first", 1);
//		map.put("last", 5);
		map.put("auth", loginVo.getAuth());
		// 세션 정보에서 페이지 정보가 있다면 사용하고 처음이라면 세션 객체를 생성하여 유지
		int selectPage = Integer.parseInt(page);
		log.info("현재 페이지 : {}", selectPage);
		PageVo pVo = null;
		if(session.getAttribute("row") == null) {
			pVo = new PageVo();
			session.setAttribute("row", pVo);
		} else {
			pVo = (PageVo)session.getAttribute("row");
			page = String.valueOf(pVo.getPage());
		}
		// 화면을 통해서 요청받은 page의 정보를 세션정보에 입력해준다.
		
		
		pVo.setTotalCount(boardService.getAllBoardCount(map));
		pVo.setCountList(10);
		pVo.setCountPage(5);
//		pVo.setTotalPage(pVo.getTotalCount());
		pVo.setTotalPage(0);
		pVo.setPage(selectPage);
//		pVo.setStagePage(selectPage);
//		pVo.setEndPage(pVo.getCountPage());
		pVo.setStagePage(0);
		pVo.setEndPage(0);

		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		map.put("last", pVo.getPage()*pVo.getCountList());
		log.info("[page] pVo : {}", pVo);
		List<BoardVo> lists = boardService.getAllBoardPage(map);
		model.addAttribute("lists",lists);
		model.addAttribute("page",pVo);
		return "boardList";
	}
	
	@GetMapping("/boardDelete.do")
	public String setBoardDelflag(String seq, HttpServletResponse response, HttpSession session) throws IOException {
		log.info("BoardController 글 삭제 : {}",seq);
		UserVo loginVo = (UserVo) session.getAttribute("loginVo");
		BoardVo vo =  boardService.getOneBoard(seq);
		if(loginVo.getId().equals(vo.getId()) || loginVo.getAuth().equals("A")) {
			int row = boardService.setBoardDelflag(seq);
			// 삭제되는 글의 소유자 및 권한을 확인하여 처리해줘야한다.
			if(row == 1) {
				return "redirect:/boardList.do";
			} else {
				SpringUtils.responseAlert(response,"잘못된 삭제 요청", "logout.do");
				return null;
			}
		} else {
			SpringUtils.responseAlert(response,"잘못된 삭제 요청", "logout.do");
			return null;
		}
		
	}
}
