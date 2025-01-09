package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

// TODO 10616 Service 작성
@Service
@Slf4j
public class BoardServiceImpl implements IBoardService{
	
	@Autowired
	private IBoardDao boardDao;
	
	@Override
	public List<BoardDto> selectBoard() {
		log.info("BoardServiceImpl selectBoard()");
		return boardDao.selectBoard();
	}

	@Override
	public int insertBoard(BoardDto dto) {
		log.info("BoardServiceImpl insertBoard()");
		return boardDao.insertBoard(dto);
	}

}
