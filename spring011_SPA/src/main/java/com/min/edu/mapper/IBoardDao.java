package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {
	List<BoardVo> getAllBoardPage(Map<String, Object> map);
	int getAllBoardCount(Map<String, Object> map);
	
	int setBoardDelflag(String seq);
	
	BoardVo getOneBoard(String seq);
	
	int setBoardUpdate(Map<String, Object> map);
	
	int setReplyUpdate(BoardVo boardVo);
	int setReplyInsert(BoardVo boardVo);
}
