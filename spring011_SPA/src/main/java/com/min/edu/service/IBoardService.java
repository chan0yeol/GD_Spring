package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {
	List<BoardVo> getAllBoardPage(Map<String, Object> map);
	int getAllBoardCount(Map<String, Object> map);
	
	int setBoardDelflag(String seq);
	
	BoardVo getOneBoard(String seq);
	
	int setBoardUpdate(Map<String, Object> map);
	
	boolean setReply(BoardVo boardVo);
}
