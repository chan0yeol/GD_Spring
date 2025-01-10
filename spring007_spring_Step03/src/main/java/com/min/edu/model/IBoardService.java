package com.min.edu.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.edu.dto.BoardDto;

// TODO 10614 service interface 정의
// DAO를 조합하여 IoC를 통한 Transaction 제어
public interface IBoardService {
	public List<BoardDto> selectBoard();
	public int insertBoard(Object dto);
	
	int transaction(BoardDto dto);
}
