package com.min.edu.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.edu.dto.BoardDto;

public interface IBoardDao {
	public List<BoardDto> selectBoard();
	public int insertBoard(BoardDto dto);
	public int updateBoard();
}
