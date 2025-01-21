package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestBoardListPageController {
	private final IBoardService boardService;
	// TODO 010 RestController 페이징 처리
	@PostMapping(value="/page.do")
	public Map<String, Object> page(@RequestParam(name="page") int selectPage, 
									HttpSession session, 
									Model model){
		log.info("[REST POST] RestBoardListPageController 게시판 페이징 페이지 값 : {}",selectPage);
		UserVo loginVo = (UserVo)session.getAttribute("loginVo");
		PageVo pVo = (PageVo) session.getAttribute("row");
		pVo.setTotalCount(boardService.getAllBoardCount(new HashMap<String, Object>(){{ put("auth",loginVo.getAuth()); }}));
		pVo.setCountList(10);
		pVo.setCountPage(5);
		pVo.setTotalPage(pVo.getTotalPage());
		pVo.setPage(selectPage);
		pVo.setStagePage(selectPage);
		pVo.setEndPage(pVo.getCountPage());
		
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
			put("last", pVo.getPage()*pVo.getCountList());
		}};
		List<BoardVo> lists = boardService.getAllBoardPage(map);
		
		// Map 으로 반환하면 -> jackson bind에 의해 자동으로 JSON 으로 변경됨
		Map<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("lists", lists);
		res_map.put("row", pVo);
		// javascript에서 session의 값을 처리하지 못하기 때문에 값으로 id만을 전송함.
		res_map.put("memId", loginVo.getId());
		
		return res_map; 
	}
}
