package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {

	private final IBoardDao boardDao;

	@Override
	public List<BoardVo> getAllBoardPage(Map<String, Object> map) {
		log.info("게시글 전체 조회 page : 범위 및 권한 {} ", map);
		return boardDao.getAllBoardPage(map);
	}

	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		log.info("게시글 전체 갯수 : 권한 {}", map);
		return boardDao.getAllBoardCount(map);
	}

	@Override
	public int setBoardDelflag(String seq) {
		log.info("setBoardDelflag() 게시글 삭제 : {}", seq);
		return boardDao.setBoardDelflag(seq);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		log.info("getOneBoard(String seq) 게시글 한개 조회 {} ", seq);
		return boardDao.getOneBoard(seq);
	}

	@Override
	public int setBoardUpdate(Map<String, Object> map) {
		log.info("setBoardUpdate(map)  게시글 수정 : {} ", map);
		return boardDao.setBoardUpdate(map);
	}

	@Override
	public boolean setReply(BoardVo boardVo) {
		log.info("게시글 답글 업데이트 및 입력 : {} ", boardVo);
		int n = boardDao.setReplyUpdate(boardVo);
		int m = boardDao.setReplyInsert(boardVo);
		return (n + m) > 0 ? true : false;
	}

}
